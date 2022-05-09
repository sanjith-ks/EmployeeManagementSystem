package com.employee.management.models;

public class TimeInfo {
	
	private int Employee_ID_Number;
	private int Worked_Hours;
	private int Off_Hours;
	private int Days_Off;
	private int Over_Time;
	private int Extra_Days;
	private int w_From_Date_Day;
	private int w_From_Date_Month;
	private int w_From_Date_Year;
	private int w_To_Date_Day;
	private int w_To_Date_Month;
	private int w_To_Date_Year;
	public int getEmployee_ID_Number() {
		return Employee_ID_Number;
	}
	public void setEmployee_ID_Number(int employee_ID_Number) {
		Employee_ID_Number = employee_ID_Number;
	}
	public int getWorked_Hours() {
		return Worked_Hours;
	}
	public void setWorked_Hours(int worked_Hours) {
		Worked_Hours = worked_Hours;
	}
	public int getOff_Hours() {
		return Off_Hours;
	}
	public void setOff_Hours(int off_Hours) {
		Off_Hours = off_Hours;
	}
	public int getDays_Off() {
		return Days_Off;
	}
	public void setDays_Off(int days_Off) {
		Days_Off = days_Off;
	}
	public int getOver_Time() {
		return Over_Time;
	}
	public void setOver_Time(int over_Time) {
		Over_Time = over_Time;
	}
	public int getExtra_Days() {
		return Extra_Days;
	}
	public void setExtra_Days(int extra_Days) {
		Extra_Days = extra_Days;
	}
	public int getW_From_Date_Day() {
		return w_From_Date_Day;
	}
	public void setW_From_Date_Day(int w_From_Date_Day) {
		this.w_From_Date_Day = w_From_Date_Day;
	}
	public int getW_From_Date_Month() {
		return w_From_Date_Month;
	}
	public void setW_From_Date_Month(int w_From_Date_Month) {
		this.w_From_Date_Month = w_From_Date_Month;
	}
	public int getW_From_Date_Year() {
		return w_From_Date_Year;
	}
	public void setW_From_Date_Year(int w_From_Date_Year) {
		this.w_From_Date_Year = w_From_Date_Year;
	}
	public int getW_To_Date_Day() {
		return w_To_Date_Day;
	}
	public void setW_To_Date_Day(int w_To_Date_Day) {
		this.w_To_Date_Day = w_To_Date_Day;
	}
	public int getW_To_Date_Month() {
		return w_To_Date_Month;
	}
	public void setW_To_Date_Month(int w_To_Date_Month) {
		this.w_To_Date_Month = w_To_Date_Month;
	}
	public int getW_To_Date_Year() {
		return w_To_Date_Year;
	}
	public void setW_To_Date_Year(int w_To_Date_Year) {
		this.w_To_Date_Year = w_To_Date_Year;
	}
	@Override
	public String toString() {
		return "\nTime Information:\nEmployee_ID_Number=" + Employee_ID_Number + "\nWorked_Hours=" + Worked_Hours + "\nOff_Hours="
				+ Off_Hours + "\nDays_Off=" + Days_Off + "\nOver_Time=" + Over_Time + "\nExtra_Days=" + Extra_Days
				+ "\nw_From_Date_Day=" + w_From_Date_Day + "\nw_From_Date_Month=" + w_From_Date_Month
				+ "\nw_From_Date_Year=" + w_From_Date_Year + "\nw_To_Date_Day=" + w_To_Date_Day + "\nw_To_Date_Month="
				+ w_To_Date_Month + "\nw_To_Date_Year=" + w_To_Date_Year ;
	}
	
	

}
