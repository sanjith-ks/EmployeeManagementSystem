package com.employee.management.models;

public class WorkHistory {
	
	private int employeeIDNumber;
	private String companyName;
	private String employerName;
	private String companyEmployerAddress;
	private long companyEmployerCellularPhone;
	private long company_Employer_Office_Phone;
	private String previousQualification;
	private String previousExperience;
	private int pStartDateDay;
	private int pStartDateMonth;
	private int pStartDateYear;
	private int pEndDateDay;
	private int pEndDateMonth;
	private int pEndDateYear;
	public int getEmployeeIDNumber() {
		return employeeIDNumber;
	}
	public void setEmployeeIDNumber(int employeeIDNumber) {
		this.employeeIDNumber = employeeIDNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getCompanyEmployerAddress() {
		return companyEmployerAddress;
	}
	public void setCompanyEmployerAddress(String companyEmployerAddress) {
		this.companyEmployerAddress = companyEmployerAddress;
	}
	public long getCompanyEmployerCellularPhone() {
		return companyEmployerCellularPhone;
	}
	public void setCompanyEmployerCellularPhone(long companyEmployerCellularPhone) {
		this.companyEmployerCellularPhone = companyEmployerCellularPhone;
	}
	public long getCompany_Employer_Office_Phone() {
		return company_Employer_Office_Phone;
	}
	public void setCompany_Employer_Office_Phone(long company_Employer_Office_Phone) {
		this.company_Employer_Office_Phone = company_Employer_Office_Phone;
	}
	public String getPreviousQualification() {
		return previousQualification;
	}
	public void setPreviousQualification(String previousQualification) {
		this.previousQualification = previousQualification;
	}
	public String getPreviousExperience() {
		return previousExperience;
	}
	public void setPreviousExperience(String previousExperience) {
		this.previousExperience = previousExperience;
	}
	public int getpStartDateDay() {
		return pStartDateDay;
	}
	public void setpStartDateDay(int pStartDateDay) {
		this.pStartDateDay = pStartDateDay;
	}
	public int getpStartDateMonth() {
		return pStartDateMonth;
	}
	public void setpStartDateMonth(int pStartDateMonth) {
		this.pStartDateMonth = pStartDateMonth;
	}
	public int getpStartDateYear() {
		return pStartDateYear;
	}
	public void setpStartDateYear(int pStartDateYear) {
		this.pStartDateYear = pStartDateYear;
	}
	public int getpEndDateDay() {
		return pEndDateDay;
	}
	public void setpEndDateDay(int pEndDateDay) {
		this.pEndDateDay = pEndDateDay;
	}
	public int getpEndDateMonth() {
		return pEndDateMonth;
	}
	public void setpEndDateMonth(int pEndDateMonth) {
		this.pEndDateMonth = pEndDateMonth;
	}
	public int getpEndDateYear() {
		return pEndDateYear;
	}
	public void setpEndDateYear(int pEndDateYear) {
		this.pEndDateYear = pEndDateYear;
	}
	@Override
	public String toString() {
		return "\nWork History :\nemployeeIDNumber=" + employeeIDNumber + "\ncompanyName=" + companyName + "\nemployerName="
				+ employerName + "\ncompanyEmployerAddress=" + companyEmployerAddress
				+ "\ncompanyEmployerCellularPhone=" + companyEmployerCellularPhone + "\ncompany_Employer_Office_Phone="
				+ company_Employer_Office_Phone + "\npreviousQualification=" + previousQualification
				+ "\npreviousExperience=" + previousExperience + "\npStartDateDay=" + pStartDateDay
				+ "\npStartDateMonth=" + pStartDateMonth + "\npStartDateYear=" + pStartDateYear + "\npEndDateDay="
				+ pEndDateDay + "\npEndDateMonth=" + pEndDateMonth + "\npEndDateYear=" + pEndDateYear;
	}
	
	

}
