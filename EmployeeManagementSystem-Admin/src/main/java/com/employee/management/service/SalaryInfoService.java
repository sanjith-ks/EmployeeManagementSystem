package com.employee.management.service;

import java.util.List;

import com.employee.management.models.SalaryInfo;

public interface SalaryInfoService {	

	/*
	 * function to get all employee salary information details
	 */
	List<SalaryInfo> getAllDataService();

	/*
	 * function to get employee salary information using id number
	 */
	SalaryInfo getDataByIdService(int id);

	/*
	 * function to insert data into employee salary information table
	 */
	String putDataService(SalaryInfo s);

	/*
	 * function to remove data from employee salary information table
	 */
	String removeDataByIdService(int id);

	/**
	 * function used to sort by name from employee salary information table
	 * @return List<SalaryInfo>
	 */
	List<SalaryInfo> sortBySalaryService();

	/**
	 * Method to update salary information of an employee
	 * @param s
	 * @return String
	 */
	String updateSalaryInfoService(SalaryInfo s);
}
