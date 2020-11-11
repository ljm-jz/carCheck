package com.xnxy.carcheck.po;

import java.util.Date;

public class History {

	private Integer id;
	private String fileName;
	private Date leadTime;
	private Integer managerId;
	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(Integer id, String fileName, Date leadTime) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.leadTime = leadTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(Date leadTime) {
		this.leadTime = leadTime;
	}


	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

}
