package com.xnxy.carcheck.vo;

/**
 * ���ڷ�����ݴ�����
 * 
 * @author Administrator
 * 
 */
public class Message {
	private Integer status;
	private String message;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
