package com.xnxy.carcheck.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.xnxy.carcheck.vo.FileVo;

public class ScanningFileUtil {

	
	public static List<FileVo> getFileList(String path) throws Exception
	{
		File directory=new File(path);
		String dname=directory.getName();
		List<FileVo> list=new ArrayList();
		File[] files = directory.listFiles();
		for (File file : files) {
			String fileName=file.getName();
			if(fileName.endsWith(".xls"))
			{
				FileVo fv=new FileVo();
				fv.setFileName(fileName);
				fv.setFileUrl("./"+dname+"/"+fileName);
				fv.setDate(fileName.substring(0,4)+"-"+fileName.substring(4,6)+"-"+fileName.substring(6,8));
				fv.setFilePath(path+"/"+fileName);
				list.add(fv);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(getFileList("D:/apache-tomcat-7.0.82/webapps/CarCheck/upload"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
