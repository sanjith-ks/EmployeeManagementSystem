package com.employee.management.models;

public class SalaryInfo {
	
	private int employeeIDNumber;
	private int monthlySalary;
	private String monthlyMoneyCurrency;
	private int monthlyTaxes;
	private int monthlydeductions;
	private int salary_cycle;
	private int net_salary;
	private int paid_salary;
	private int payable_salary;
	
	
	public int getEmployeeIDNumber() {
		return employeeIDNumber;
	}
	public void setEmployeeIDNumber(int employeeIDNumber) {
		this.employeeIDNumber = employeeIDNumber;
	}
	public int getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public String getMonthlyMoneyCurrency() {
		return monthlyMoneyCurrency;
	}
	public void setMonthlyMoneyCurrency(String monthlyMoneyCurrency) {
		this.monthlyMoneyCurrency = monthlyMoneyCurrency;
	}
	public int getMonthlyTaxes() {
		return monthlyTaxes;
	}
	
	public int getMonthlydeductions() {
		return monthlydeductions;
	}
	
	public int getSalary_cycle() {
		return salary_cycle;
	}
	public void setSalary_cycle(int salary_cycle) {
		this.salary_cycle = salary_cycle;
	}
	public int getNet_salary() {
		return net_salary;
	}
	public int getPaid_salary() {
		return paid_salary;
	}
	public void setPaid_salary(int paid_salary) {
		this.paid_salary = paid_salary;
	}
	public int getPayable_salary() {
		return payable_salary;
	}
	
	public void setMonthlyTaxes(int monthlyTaxes) {
		this.monthlyTaxes = monthlyTaxes;
	}
	public void setMonthlydeductions(int monthlydeductions) {
		this.monthlydeductions = monthlydeductions;
	}
	public void setNet_salary(int net_salary) {
		this.net_salary = net_salary;
	}
	public void setPayable_salary(int payable_salary) {
		this.payable_salary = payable_salary;
	}
	@Override
	public String toString() {
		return "Salary Information :\nemployeeIDNumber=" + employeeIDNumber + "\nmonthlySalary=" + monthlySalary
				+ "\nmonthlyMoneyCurrency=" + monthlyMoneyCurrency + "\nmonthlyTaxes=" + monthlyTaxes
				+ "\nmonthlydeductions=" + monthlydeductions + "\nsalary_cycle=" + salary_cycle + "\nnet_salary="
				+ net_salary + "\npaid_salary=" + paid_salary + "\npayable_salary=" + payable_salary ;
	}

	 
	


}
