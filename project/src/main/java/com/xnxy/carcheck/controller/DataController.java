package com.xnxy.carcheck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.xnxy.carcheck.po.Manager;
import com.xnxy.carcheck.service.DataService;
import com.xnxy.carcheck.vo.HistoryVo;
import com.xnxy.carcheck.vo.Message;
import com.xnxy.carcheck.vo.UploadVo;


@Controller
@SessionAttributes({ "manager" })
public class DataController {

	@Autowired
	private DataService ds;
	
	//下载文件
	@RequestMapping("/download.action")
	public ResponseEntity<byte[]> download()
	{
		return ds.download();
	}
	
	//通过本地文件导入数据
	@RequestMapping("/leadingin.action")
	@ResponseBody
	public Object leadingIn(MultipartFile file,ModelMap map)
	{
		Manager m=(Manager) map.get("manager");
		try {
			return ds.leadingIn(null, file,m.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new UploadVo(1, "数据导入异常",null );
		}
	}
	
	//数据备份
	@RequestMapping("/leadingout.action")
	@ResponseBody
	public Message leadingOut()
	{
		return ds.leadingOut();
	}
	
	//数据恢复
	@RequestMapping("/recovery.action")
	@ResponseBody
	public Object recovery(@RequestParam("filePath") String filePath,ModelMap map)
	{
		Manager m=(Manager) map.get("manager");
		try {
			return ds.leadingIn(filePath, null,m.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(0,"数据恢复失败");
		}
	}
	
	//获取备份文件列表
	@RequestMapping("fileList.action")
	@ResponseBody
	public Object getFileList()
	{
		return ds.getFileList();
	}
	
	//获取历史导入数据
	@RequestMapping("/history.action")
	@ResponseBody
	public List<HistoryVo> getHistory(){
		return ds.getHistory();
	}
}
