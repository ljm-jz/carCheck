package com.xnxy.carcheck.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnxy.carcheck.dao.CarInfoDao;
import com.xnxy.carcheck.po.CarInfo;
import com.xnxy.carcheck.service.CarInfoService;
import com.xnxy.carcheck.util.SendMsgUtil;
import com.xnxy.carcheck.vo.CarInfoVo;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.PageListVo;

/**
 * 
 * @author mumu
 *
 */
@Service
public class CarInfoServiceImpl implements CarInfoService{

	@Autowired
	private CarInfoDao carInfoDao;
	
	
	/*
	 * (non-Javadoc)
	 * @see com.xnxy.carcheck.service.CarInfoService#updataCarInfo(com.xnxy.carcheck.po.CarInfo)
	 */
	@Override
	public Message updataCarInfo(CarInfoVo carInfo) throws Exception{
		// TODO Auto-generated method stub
		Message msg=new Message();
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		CarInfo cf=new CarInfo(carInfo.getId(), carInfo.getCarId(), carInfo.getCarType(), carInfo.getOwnnerName(), carInfo.getOwnnerPhone(), sdf.parse(carInfo.getCarCheckTime()), sdf.parse(carInfo.getCarInsuranceTime()), sdf.parse(carInfo.getTechnicalGradeTime()),sdf.parse(carInfo.getSecondMaintenanceTime()));
		if(carInfoDao.updataCarInfo(cf)>0){
			msg.setStatus(1);
			msg.setMessage("修改成功");
		}
		else
		{
			msg.setStatus(0);
			msg.setMessage("修改失败");
		}
		return msg;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xnxy.carcheck.service.CarInfoService#deleteCarInfo(java.lang.Integer)
	 */
	@Override
	public Message deleteCarInfo(Integer id) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		if(carInfoDao.deleteCarInfo(id)>0){
			msg.setStatus(1);
			msg.setMessage("删除成功");
		}
		else{
			msg.setStatus(0);
			msg.setMessage("删除失败");
		}
		return msg;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xnxy.carcheck.service.CarInfoService#addCarInfo(com.xnxy.carcheck.po.CarInfo)
	 */
	@Override
	public Message addCarInfo(CarInfoVo carInfo) throws Exception{
		Message msg=new Message();
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		CarInfo cf=new CarInfo(carInfo.getId(), carInfo.getCarId(), carInfo.getCarType(), carInfo.getOwnnerName(), carInfo.getOwnnerPhone(), sdf.parse(carInfo.getCarCheckTime()), sdf.parse(carInfo.getCarInsuranceTime()), sdf.parse(carInfo.getTechnicalGradeTime()),sdf.parse(carInfo.getSecondMaintenanceTime()));
		if(carInfoDao.addCarInfo(cf)>0){
			msg.setStatus(1);
			msg.setMessage("添加成功");
		}
		else{
			msg.setStatus(0);
			msg.setMessage("添加失败");
		}
		return msg;	}

	/*
	 * (non-Javadoc)
	 * @see com.xnxy.carcheck.service.CarInfoService#queryCarInfo(java.lang.String)
	 */
	@Override
	public PageListVo<CarInfo> queryCarInfo(String condition) {
		// TODO Auto-generated method stub
		PageListVo<CarInfo> plv=new PageListVo();
		System.out.println(condition);
		List<CarInfo> list=null;
		
		if("".equals(condition))
		{
			list=carInfoDao.queryCarInfo();
		}else{
			list=carInfoDao.queryFiewCarInfo("%"+condition+"%");
		}
		plv.setCode(0);
		plv.setCount(list.size());
		plv.setMsg("");
		plv.setData(list);
		return plv;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.xnxy.carcheck.service.CarInfoService#checkCarId(java.lang.String)
	 */
	@Override
	public Message checkCarId(String carId) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		if(carInfoDao.checkCarId(carId)>0){
			msg.setStatus(0);
			msg.setMessage("此车牌号已存在,请到修改页面进行修改");
		}
		else{
			msg.setStatus(1);
			msg.setMessage("此车牌可登记");
		}
		
		return msg;
	}

	@Override
	public Message notice(CarInfo carInfo) throws Exception {
		String msg="【木影提示】"+carInfo.getOwnnerName()+"先生/女士,您好!您爱车"+carInfo.getCarId();
		String msg1=getMsg(carInfo.getCarCheckTime());
		String msg2=getMsg(carInfo.getCarInsuranceTime());
		String msg3=getMsg(carInfo.getTechnicalGradeTime());
		String msg4=getMsg(carInfo.getSecondMaintenanceTime());
		/*if(!"".equals(msg1)){
			SendMsgUtil.sendMsg(carInfo.getOwnnerPhone(), msg+"的车检"+msg1);
		}
		if(!"".equals(msg2)){
			SendMsgUtil.sendMsg(carInfo.getOwnnerPhone(), msg+"的保险"+msg2);
		}
		if(!"".equals(msg3)){
			SendMsgUtil.sendMsg(carInfo.getOwnnerPhone(), msg+"的技术等级评定"+msg3);
		}
		if(!"".equals(msg4)){
			SendMsgUtil.sendMsg(carInfo.getOwnnerPhone(), msg+"的二级维护"+msg4);
		}*/
		return new Message(1,"发送成功");
	}
	
	public String getMsg(Date date){
		String msg="";
		Date now=new Date();
		Date now1=now;
		now1.setDate(+7);
		if(date.after(now)){
			msg="已经过期,请您尽快办理相关手续，避免对您的车行造成影响";
		}else if(date.after(now1)){
			msg="即将过期,请您尽快办理相关手续，避免对您的车行造成影响";
		}
		return msg;
	}
	
	public static void main(String[] args) {
		Object obj=null;
		String str=null;
		System.out.println(obj==null);
		System.out.println(str==null);
	}

}
