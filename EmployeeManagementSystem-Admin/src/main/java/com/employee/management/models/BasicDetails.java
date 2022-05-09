package com.employee.management.models;


public class BasicDetails {
	
	
	private int employeeIDNumber;
	private int personalIDNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private int dayOfBirth;
	private int monthOfBirth;
	private int yearOfBirth;
	private long cellularPhone;
	private long homePhone;
	private String city;
	private String address;
	private int postalCode;
	private String qualification;
	private String currentExperience;
	private int startDateDay;
	private int startDateMonth;
	private int startDateYear;
	private int endDateDay;
	private int endDateMonth;
	private int endDateYear;
	private String typeOfEmployee;
	private String gender;
	private String maritalStatus;
	public int getEmployeeIDNumber() {
		return employeeIDNumber;
	}
	public void setEmployeeIDNumber(int employeeIDNumber) {
		this.employeeIDNumber = employeeIDNumber;
	}
	public int getPersonalIDNumber() {
		return personalIDNumber;
	}
	public void setPersonalIDNumber(int personalIDNumber) {
		this.personalIDNumber = personalIDNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public int getMonthOfBirth() {
		return monthOfBirth;
	}
	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public long getCellularPhone() {
		return cellularPhone;
	}
	public void setCellularPhone(long cellularPhone) {
		this.cellularPhone = cellularPhone;
	}
	public long getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(long homePhone) {
		this.homePhone = homePhone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCurrentExperience() {
		return currentExperience;
	}
	public void setCurrentExperience(String currentExperience) {
		this.currentExperience = currentExperience;
	}
	public int getStartDateDay() {
		return startDateDay;
	}
	public void setStartDateDay(int startDateDay) {
		this.startDateDay = startDateDay;
	}
	public int getStartDateMonth() {
		return startDateMonth;
	}
	public void setStartDateMonth(int startDateMonth) {
		this.startDateMonth = startDateMonth;
	}
	public int getStartDateYear() {
		return startDateYear;
	}
	public void setStartDateYear(int startDateYear) {
		this.startDateYear = startDateYear;
	}
	public int getEndDateDay() {
		return endDateDay;
	}
	public void setEndDateDay(int endDateDay) {
		this.endDateDay = endDateDay;
	}
	public int getEndDateMonth() {
		return endDateMonth;
	}
	public void setEndDateMonth(int endDateMonth) {
		this.endDateMonth = endDateMonth;
	}
	public int getEndDateYear() {
		return endDateYear;
	}
	public void setEndDateYear(int endDateYear) {
		this.endDateYear = endDateYear;
	}
	public String getTypeOfEmployee() {
		return typeOfEmployee;
	}
	public void setTypeOfEmployee(String typeOfEmployee) {
		this.typeOfEmployee = typeOfEmployee;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	@Override
	public String toString() {
		return "\n Employee BasicDetails :\nemployeeIDNumber=" + employeeIDNumber + "\npersonalIDNumber=" + personalIDNumber
				+ "\nfirstName=" + firstName + "\nmiddleName=" + middleName + "\nlastName=" + lastName + "\ndayOfBirth="
				+ dayOfBirth + "\nmonthOfBirth=" + monthOfBirth + "\nyearOfBirth=" + yearOfBirth + "\ncellularPhone="
				+ cellularPhone + "\nhomePhone=" + homePhone + "\ncity=" + city + "\naddress=" + address
				+ "\npostalCode=" + postalCode + "\nqualification=" + qualification + "\ncurrentExperience="
				+ currentExperience + "\nstartDateDay=" + startDateDay + "\nstartDateMonth=" + startDateMonth
				+ "\nstartDateYear=" + startDateYear + "\nendDateDay=" + endDateDay + "\nendDateMonth=" + endDateMonth
				+ "\nendDateYear=" + endDateYear + "\ntypeOfEmployee=" + typeOfEmployee + "\ngender=" + gender
				+ "\nmaritalStatus=" + maritalStatus;
	}
	

}
