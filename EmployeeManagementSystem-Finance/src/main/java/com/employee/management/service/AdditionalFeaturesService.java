package com.employee.management.service;

public interface AdditionalFeaturesService {
	
	/*
	 * function to add salary details into salary information table
	 */
	String paySalaryService(int sal,int id);
	
	/*
	 * function to get employee salary details along with name
	 */
	String getSalaryWithNameService();
	
	/*
	 * function to update employee salary details 
	 */
	String updateSalaryService(int sal, int id);
}
