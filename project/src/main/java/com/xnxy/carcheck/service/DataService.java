package com.xnxy.carcheck.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.xnxy.carcheck.vo.FileVo;
import com.xnxy.carcheck.vo.HistoryVo;
import com.xnxy.carcheck.vo.Message;

/**
 * 
 * @author Administrator
 *
 */
public interface DataService {
	/**
	 * 
	 * @return
	 */
	public Object leadingIn(String filePath, MultipartFile file, Integer id) throws Exception;
	
	/**
	 * 
	 * @return
	 */
	public ResponseEntity<byte[]> download();
	
	/**
	 * 
	 * @return
	 */
	public Message leadingOut();

	public List<FileVo> getFileList();

	public List<HistoryVo> getHistory();
}
