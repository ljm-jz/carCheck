package com.xnxy.carcheck.po;

/**
 * ��������Ϣ�࣬���¼���¼���롢��ϵ�绰����ʵ�������䡢�Ա�סַ
 * 
 * @author Administrator
 * 
 */
public class Manager {
	private Integer id;
	private String name;
	private String pwd;
	private String phone;
	private String realName;
	private Integer age;
	private Integer sex;
	private String address;
	private Integer role;

	public Manager() {
		
	}

	public Manager(String name, String pwd, String phone, String realName,
			Integer age, Integer sex, String address,Integer role) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.realName = realName;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.role=role;
	}

	public Manager(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
