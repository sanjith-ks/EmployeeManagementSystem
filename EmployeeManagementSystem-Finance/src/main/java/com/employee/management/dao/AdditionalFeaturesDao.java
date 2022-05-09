package com.employee.management.dao;

public interface AdditionalFeaturesDao {
	
	/*
	 * function to add salary details salary information table
	 */
	String paySalaryDao(int sal,int id);
	
	/*
	 * function to get salary details along with name
	 */
	String getSalaryWithNameDao();
    
	/*
	 * function to clear salary value in salary information table
	 */
	void clearPaidSalaryDao();
	
	/*
	 * function to update salary details in salary information table
	 */
	String updateSalaryDao(int sal, int id);
}
