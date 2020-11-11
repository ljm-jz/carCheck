package com.xnxy.carcheck.po;

import java.util.Date;

public class CarInfo {
	private Integer id;
	private String carId;
	private Integer carType;
	private String ownnerName;
	private String ownnerPhone;
	private Date carCheckTime;
	private Date carInsuranceTime;
	private Date technicalGradeTime;
	private Date secondMaintenanceTime;

	public CarInfo() {
		// TODO Auto-generated constructor stub
	}

	
	public CarInfo(Integer id,String carId, Integer catType, String ownnerName,
			String ownnerPhone, Date carCheckTime, Date carInsuranceTime,
			Date technicalGradeTime, Date secondMaintenanceTime) {
		super();
		this.id=id;
		this.carId = carId;
		this.carType = catType;
		this.ownnerName = ownnerName;
		this.ownnerPhone = ownnerPhone;
		this.carCheckTime = carCheckTime;
		this.carInsuranceTime = carInsuranceTime;
		this.technicalGradeTime = technicalGradeTime;
		this.secondMaintenanceTime = secondMaintenanceTime;
	}


	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Integer getCarType() {
		return carType;
	}

	public void setCarType(Integer catType) {
		this.carType = catType;
	}

	public String getOwnnerName() {
		return ownnerName;
	}

	public void setOwnnerName(String ownnerName) {
		this.ownnerName = ownnerName;
	}

	public String getOwnnerPhone() {
		return ownnerPhone;
	}

	public void setOwnnerPhone(String ownnerPhone) {
		this.ownnerPhone = ownnerPhone;
	}

	public Date getCarCheckTime() {
		return carCheckTime;
	}

	public void setCarCheckTime(Date carCheckTime) {
		this.carCheckTime = carCheckTime;
	}

	public Date getCarInsuranceTime() {
		return carInsuranceTime;
	}

	public void setCarInsuranceTime(Date carInsuranceTime) {
		this.carInsuranceTime = carInsuranceTime;
	}


	public Date getSecondMaintenanceTime() {
		return secondMaintenanceTime;
	}

	public void setSecondMaintenanceTime(Date secondMaintenanceTime) {
		this.secondMaintenanceTime = secondMaintenanceTime;
	}

	public Date getTechnicalGradeTime() {
		return technicalGradeTime;
	}

	public void setTechnicalGradeTime(Date technicalGradeTime) {
		this.technicalGradeTime = technicalGradeTime;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "CarInfo [id=" + id + ", carId=" + carId + ", carType="
				+ carType + ", ownnerName=" + ownnerName + ", ownnerPhone="
				+ ownnerPhone + ", carCheckTime=" + carCheckTime
				+ ", carInsuranceTime=" + carInsuranceTime
				+ ", technicalGradeTime=" + technicalGradeTime
				+ ", secondMaintenanceTime=" + secondMaintenanceTime + "]";
	}
	
	
}
