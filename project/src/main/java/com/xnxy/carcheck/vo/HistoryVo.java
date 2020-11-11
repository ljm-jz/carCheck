package com.xnxy.carcheck.vo;

import java.util.Date;

public class HistoryVo {
	private Integer id;
	private String fileName;
	private Date leadTime;
	private String name;

	public HistoryVo() {
		// TODO Auto-generated constructor stub
	}

	public HistoryVo(Integer id, String fileName, Date leadTime, String name) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.leadTime = leadTime;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
