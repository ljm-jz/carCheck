package com.xnxy.carcheck.vo;

public class FileVo {
	private String date;
	private String filePath;

	private String fileName;
	private String fileUrl;

	public FileVo() {
		// TODO Auto-generated constructor stub
	}

	public FileVo(String fileName, String fileUrl) {
		super();
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}

	public FileVo( String date, String recovery, String fileName,
			String fileUrl) {
		super();
		this.date = date;
		this.filePath = recovery;
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FileVo [date=" + date + ", recovery=" + filePath
				+ ", fileName=" + fileName + ", fileUrl=" + fileUrl + "]";
	}

	
}
