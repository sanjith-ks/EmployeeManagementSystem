package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.BasicDetails;

public interface EmployeeBasicDao {
	
	/*
	 * function to get all employee basic information details
	 */
	List<BasicDetails> getAllDataDao();
	
	/*
	 * function to insert data into employee basic information table
	 */
	String putDataDao(BasicDetails b);
	
	/*
	 *  function to remove data from employee basic information table
	 */
	String removeDataByIdDao(int id);

	/*
	 *  function to sort data by name from employee basic information table
	 */
	List<BasicDetails> sortByNameDao();

	/**
	 * Method to update basic details for an employee
	 * @param b
	 * @return String
	 */
	String updateBasicInfoDao(BasicDetails b);
}
