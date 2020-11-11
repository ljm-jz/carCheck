package com.xnxy.carcheck.vo;

public class CarInfoVo {
	private Integer id;
	private String carId;
	private Integer carType;
	private String ownnerName;
	private String ownnerPhone;
	private String carCheckTime;
	private String carInsuranceTime;
	private String technicalGradeTime;
	private String secondMaintenanceTime;

	public CarInfoVo() {
		// TODO Auto-generated constructor stub
	}

	public CarInfoVo(Integer id, String carId, Integer carType,
			String ownnerName, String ownnerPhone, String carCheckTime,
			String carInsuranceTime, String technicalGradeTime,
			String secondMaintenanceTime) {
		super();
		this.id = id;
		this.carId = carId;
		this.carType = carType;
		this.ownnerName = ownnerName;
		this.ownnerPhone = ownnerPhone;
		this.carCheckTime = carCheckTime;
		this.carInsuranceTime = carInsuranceTime;
		this.technicalGradeTime = technicalGradeTime;
		this.secondMaintenanceTime = secondMaintenanceTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setCarType(Integer carType) {
		this.carType = carType;
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

	public String getCarCheckTime() {
		return carCheckTime;
	}

	public void setCarCheckTime(String carCheckTime) {
		this.carCheckTime = carCheckTime;
	}

	public String getCarInsuranceTime() {
		return carInsuranceTime;
	}

	public void setCarInsuranceTime(String carInsuranceTime) {
		this.carInsuranceTime = carInsuranceTime;
	}

	public String getTechnicalGradeTime() {
		return technicalGradeTime;
	}

	public void setTechnicalGradeTime(String technicalGradeTime) {
		this.technicalGradeTime = technicalGradeTime;
	}

	public String getSecondMaintenanceTime() {
		return secondMaintenanceTime;
	}

	public void setSecondMaintenanceTime(String secondMaintenanceTime) {
		this.secondMaintenanceTime = secondMaintenanceTime;
	}


}
