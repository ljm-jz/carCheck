package com.xnxy.carcheck.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xnxy.carcheck.dao.CarInfoDao;
import com.xnxy.carcheck.dao.HistoryDao;
import com.xnxy.carcheck.po.CarInfo;
import com.xnxy.carcheck.service.DataService;
import com.xnxy.carcheck.util.ScanningFileUtil;
import com.xnxy.carcheck.vo.FileVo;
import com.xnxy.carcheck.vo.HistoryVo;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.UploadVo;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class DataServiceImpl implements DataService{

	@Autowired
	private CarInfoDao carinfoDao;
	@Autowired
	private HistoryDao hd;
	@Override
	public Object leadingIn(String filePath,MultipartFile file,Integer id) throws Exception {
		// TODO Auto-generated method stub
		List<CarInfo> carInfo=new ArrayList();
		Object obj=null;
		String fileName="";
		if(filePath==null){
			fileName=file.getOriginalFilename();
			if(fileName.endsWith(".xls")){
				carInfo=readExcel(file.getInputStream());
				obj=new UploadVo(0,"上传文件成功，数据导入结束",null);
			}else{
				obj=new UploadVo(2,"文件类型错误，请选择.xls文件",null);
				return obj;
			}
		}
		else{
			File localFile=new File(filePath);
			fileName=localFile.getName();
			carInfo=readExcel(new FileInputStream(localFile));
			obj=new Message(1,"finished");
		}
		carinfoDao.truncatCarInfo();//清空数据库中的信息
		carinfoDao.insertBatch(carInfo);//批量导入检车信息
		hd.saveHistory(fileName, new Date(), id);
		return obj;
	}

	@Override
	public ResponseEntity<byte[]> download() {
		// TODO Auto-generated method stub
		try {
			String path=checkOut(carinfoDao.queryCarInfo());//获取备份文件的路径
			File file=new File(path);
			HttpHeaders header=new HttpHeaders();//获取请求头
			String fileName=new String("车检信息表.xls".getBytes("UTF-8"),"iso-8859-1");
			header.setContentDispositionFormData("attachment", fileName);//设置下载文件名
			header.setContentType(MediaType.APPLICATION_OCTET_STREAM);//以二进制的形式传输文件
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), header,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Message leadingOut() {
		// TODO Auto-generated method stub
		try {
			checkOut(carinfoDao.queryCarInfo());
			return new Message(1,"数据备份完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(0,"数据备份失败");
		}
	}
	
	/**
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public List<CarInfo> readExcel(InputStream is) throws Exception
	{
		Workbook wb=new HSSFWorkbook(is);//读取Excel工作薄对象
		List<CarInfo> list=new ArrayList();
		Sheet sheet = wb.getSheetAt(0);//获取Excel工作表对象 
		if(sheet.getRow(0).getLastCellNum()!=9)
		{
			throw new Exception("表格的格式异常");
		}
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			Row row = sheet.getRow(i);//获取一行单元格
			CarInfo carinfo=new CarInfo();
			carinfo.setCarId(row.getCell(1).getStringCellValue());//获取，某一个单元格中的数据
			carinfo.setCarType(getCarType(row.getCell(2).getStringCellValue()));
			carinfo.setOwnnerName(row.getCell(3).getStringCellValue());
			carinfo.setOwnnerPhone(row.getCell(4).getStringCellValue());
			carinfo.setCarCheckTime(row.getCell(5).getDateCellValue());
			carinfo.setCarInsuranceTime(row.getCell(6).getDateCellValue());
			carinfo.setTechnicalGradeTime(row.getCell(7).getDateCellValue());
			carinfo.setSecondMaintenanceTime(row.getCell(8).getDateCellValue());
			list.add(carinfo);
		}
		return list;//返回转换后的数据
	}
	
	/**
	 * 
	 * @param carType
	 * @return
	 */
	public Integer getCarType(String carType)
	{
		if("轿车".equals(carType))
			return 1;
		else if("客车".equals(carType))
			return 2;
		else if("货车".equals(carType))
			return 3;
		else
			return null;
	}
	
	/**
	 * 
	 * @param carType
	 * @return
	 */
	public String getCarType(Integer carType)
	{
		switch (carType) {
		case 1: return "轿车";
		case 2: return "客车";
		case 3: return "货车";
		}
		return null;
	}
	
	/**
	 * 
	 * @param list
	 * @throws Exception
	 */
	public String checkOut(List<CarInfo> list) throws Exception
	{
		String path="D:/apache-tomcat-7.0.82/webapps/CarCheck/upload/";//设置文件存储根目录
		String postfix=".xls";//问价后缀
		String filePath="";
		String fileName=new SimpleDateFormat("yyyyMMdd").format(new Date());
		int count=0;
		do{
			filePath=path+fileName+(++count)+postfix;
		}while(new File(filePath).exists());
		Workbook web=new HSSFWorkbook();//创建工作簿对象
		Sheet sheet = web.createSheet("车检信息表");//创建工作表对象
		sheet.setDefaultColumnWidth(15);//设置默认列宽
		Row row = sheet.createRow(0);
		CellStyle cellStyle = web.createCellStyle();//创建列的样式
		DataFormat dataFormat = web.createDataFormat();
		cellStyle.setDataFormat(dataFormat.getFormat("yyyy/mm/dd"));//设置单元格的数据格式类型
		Cell index = row.createCell(0);//在一行单元格中创建一个列
		Cell carId = row.createCell(1);
		Cell carType = row.createCell(2);
		Cell carOwnnerName = row.createCell(3);
		Cell carOwnnerPhone = row.createCell(4);
		Cell carCheckTime = row.createCell(5);
		Cell carInstanceTime = row.createCell(6);
		Cell tlvTime = row.createCell(7);
		Cell twoTime = row.createCell(8);
		index.setCellValue("序号");//设置值
		carId.setCellValue("车牌号");
		carType.setCellValue("车辆类型");
		carOwnnerName.setCellValue("车主");
		carOwnnerPhone.setCellValue("车主联系电话");
		carCheckTime.setCellValue("车检有效时限");
		carInstanceTime.setCellValue("保险有效时限");
		tlvTime.setCellValue("技术等级有效时间");
		twoTime.setCellValue("二级维护有效时间");
		for(int i=0;i<list.size();i++)
		{
			CarInfo carinfo=list.get(i);
			Row dataRow = sheet.createRow(i+1);
			dataRow.createCell(0).setCellValue(i+1);
			dataRow.createCell(1).setCellValue(carinfo.getCarId());;
			dataRow.createCell(2).setCellValue(getCarType(carinfo.getCarType()));;
			dataRow.createCell(3).setCellValue(carinfo.getOwnnerName());
			Cell data4 = dataRow.createCell(4);
			data4.setCellType(CellType.STRING);
			data4.setCellValue(carinfo.getOwnnerPhone());
			Cell data5=dataRow.createCell(5);
			Cell data6=dataRow.createCell(6);
			Cell data7=dataRow.createCell(7);
			Cell data8=dataRow.createCell(8);
			data5.setCellStyle(cellStyle);//设置单元格数据格式
			data6.setCellStyle(cellStyle);
			data7.setCellStyle(cellStyle);
			data8.setCellStyle(cellStyle);
			data5.setCellValue(carinfo.getCarCheckTime());
			data6.setCellValue(carinfo.getCarInsuranceTime());
			data7.setCellValue(carinfo.getTechnicalGradeTime());
			data8.setCellValue(carinfo.getSecondMaintenanceTime());
		}
		web.write(new FileOutputStream(new File(filePath)));//将web对象中的内容写入到本地文件
		return filePath;//返回文件路径
	}

	@Override
	public List<FileVo> getFileList() {
		// TODO Auto-generated method stub
		try {
			return ScanningFileUtil.getFileList("D:/apache-tomcat-7.0.82/webapps/CarCheck/upload");//获取所有备份问价信息
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<HistoryVo> getHistory() {
		// TODO Auto-generated method stub
		return hd.queryHistory();
	}
	
}
