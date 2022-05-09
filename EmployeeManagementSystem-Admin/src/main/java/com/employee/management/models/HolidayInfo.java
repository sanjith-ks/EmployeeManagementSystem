package com.employee.management.models;

public class HolidayInfo {

	private int Employee_ID_Number;
	private String Holiday;
	private int h_From_Date_Day;
	private int h_From_Date_Month;
	private int h_From_Date_Year;
	private int h_To_Date_Day;
	private int h_To_Date_Month;
	private int h_To_Date_Year;
	public int getEmployee_ID_Number() {
		return Employee_ID_Number;
	}
	public void setEmployee_ID_Number(int employee_ID_Number) {
		Employee_ID_Number = employee_ID_Number;
	}
	public String getHoliday() {
		return Holiday;
	}
	public void setHoliday(String holiday) {
		Holiday = holiday;
	}
	public int getH_From_Date_Day() {
		return h_From_Date_Day;
	}
	public void setH_From_Date_Day(int h_From_Date_Day) {
		this.h_From_Date_Day = h_From_Date_Day;
	}
	public int getH_From_Date_Month() {
		return h_From_Date_Month;
	}
	public void setH_From_Date_Month(int h_From_Date_Month) {
		this.h_From_Date_Month = h_From_Date_Month;
	}
	public int getH_From_Date_Year() {
		return h_From_Date_Year;
	}
	public void setH_From_Date_Year(int h_From_Date_Year) {
		this.h_From_Date_Year = h_From_Date_Year;
	}
	public int getH_To_Date_Day() {
		return h_To_Date_Day;
	}
	public void setH_To_Date_Day(int h_To_Date_Day) {
		this.h_To_Date_Day = h_To_Date_Day;
	}
	public int getH_To_Date_Month() {
		return h_To_Date_Month;
	}
	public void setH_To_Date_Month(int h_To_Date_Month) {
		this.h_To_Date_Month = h_To_Date_Month;
	}
	public int getH_To_Date_Year() {
		return h_To_Date_Year;
	}
	public void setH_To_Date_Year(int h_To_Date_Year) {
		this.h_To_Date_Year = h_To_Date_Year;
	}
	@Override
	public String toString() {
		return "\nHolidays Information :\nEmployee_ID_Number=" + Employee_ID_Number + "\nHoliday=" + Holiday + "\nh_From_Date_Day="
				+ h_From_Date_Day + "\nh_From_Date_Month=" + h_From_Date_Month + "\nh_From_Date_Year="
				+ h_From_Date_Year + "\nh_To_Date_Day=" + h_To_Date_Day + "\nh_To_Date_Month=" + h_To_Date_Month
				+ "\nh_To_Date_Year=" + h_To_Date_Year;
	}
	
	
}
