package com.employee.management.models;

public class ContactInfo {
	
	private int employeeIDNumber;
	private String cFirstName;
	private String cMiddleName;
	private String cLastName;
	private long cCellularPhone;
	private long cHomePhone;
	private String cCity;
	private String cAddress;
	public int getEmployeeIDNumber() {
		return employeeIDNumber;
	}
	public void setEmployeeIDNumber(int employeeIDNumber) {
		this.employeeIDNumber = employeeIDNumber;
	}
	public String getcFirstName() {
		return cFirstName;
	}
	public void setcFirstName(String cFirstName) {
		this.cFirstName = cFirstName;
	}
	public String getcMiddleName() {
		return cMiddleName;
	}
	public void setcMiddleName(String cMiddleName) {
		this.cMiddleName = cMiddleName;
	}
	public String getcLastName() {
		return cLastName;
	}
	public void setcLastName(String cLastName) {
		this.cLastName = cLastName;
	}
	public long getcCellularPhone() {
		return cCellularPhone;
	}
	public void setcCellularPhone(long cCellularPhone) {
		this.cCellularPhone = cCellularPhone;
	}
	public long getcHomePhone() {
		return cHomePhone;
	}
	public void setcHomePhone(long cHomePhone) {
		this.cHomePhone = cHomePhone;
	}
	public String getcCity() {
		return cCity;
	}
	public void setcCity(String cCity) {
		this.cCity = cCity;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	@Override
	public String toString() {
		return "\nContact Information :\nemployeeIDNumber=" + employeeIDNumber + "\ncFirstName=" + cFirstName + "\ncMiddleName="
				+ cMiddleName + "\nLastName=" + cLastName + "\ncCellularPhone=" + cCellularPhone + "\ncHomePhone="
				+ cHomePhone + "\ncCity=" + cCity + "\ncAddress=" + cAddress;
	}
	
	
	


}
