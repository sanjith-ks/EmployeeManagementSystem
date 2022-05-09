package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.SalaryInfo;

public interface SalaryInfoDao {
	
	/*
	 * function to get all employee salary information details 
	 */
	List<SalaryInfo> getAllDataDao();
	
	/*
	 * function to insert data into employee salary information 
	 */
	String putDataDao(SalaryInfo s);
	
	/*
	 * function to delete employee salary information details using id
	 */
	String removeDataById(int id);
}
