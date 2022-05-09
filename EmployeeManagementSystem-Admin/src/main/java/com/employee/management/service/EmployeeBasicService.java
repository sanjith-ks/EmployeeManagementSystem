package com.employee.management.service;

import java.util.List;

import com.employee.management.models.BasicDetails;

public interface EmployeeBasicService {
	
	/*
	 * function to get all employee basic information details
	 */
	List<BasicDetails> getAllDataService();
	
	/*
	 * function to get employee basic information using id number
	 */
	BasicDetails getDataByIdService(int id);
	
	/*
	 * function to insert data into employee basic information table
	 */
	String putDataService(BasicDetails b);
	
	/*
	 *  function to remove data from employee basic information table
	 */
	String removeDataByIdService(int id);

	/*
	 *  function to sort data by name from employee basic information table
	 */
	List<BasicDetails> sortByNameService();
	
	/**
	 * Method to update basic details for an employee
	 * @param b
	 * @return String
	 */
	String updateBasicInfoService(BasicDetails b);
}
