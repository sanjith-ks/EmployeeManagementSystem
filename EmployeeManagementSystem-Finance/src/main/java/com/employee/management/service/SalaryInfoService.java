package com.employee.management.service;

import java.util.List;

import com.employee.management.models.SalaryInfo;

public interface SalaryInfoService {
	
	/*
	 * function to get all employee salary information details service
	 */
	List<SalaryInfo> getAllDataService();
	
	/*
	 * function to get employee salary information details using id
	 */
	SalaryInfo getDataByIdService(int id);
	
	/*
	 * function to insert data into employee salary information 
	 */
	String putDataService(SalaryInfo s);
	
	/*
	 * function to delete employee salary information details using id
	 */
	String removeDataByIdService(int id);
}
