package com.xnxy.carcheck.vo;

import java.util.List;

public class PageListVo<T> {
	private Integer code;
	private String msg;
	private Integer count;
	private List<T> data;

	public PageListVo() {
		// TODO Auto-generated constructor stub
	}

	public PageListVo(Integer code, String msg, Integer count, List<T> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
