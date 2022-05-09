package com.employee.management.service;

import java.util.List;

import com.employee.management.models.WorkHistory;

public interface WorkHistoryService {
	
	/*
	 * function to get all employee work history details
	 */
	List<WorkHistory> getAllDataService();
	
	/*
	 * function to get employee work history using id number
	 */
	WorkHistory getDataByIdService(int id);
	
	/*
	 * function to insert data into employee work history table
	 */
	String putDataService(WorkHistory w);
	
	/*
	 * function to remove data from employee work history table
	 */
	String removeDataByIdService(int id);

	/**
	 * method used to sort data by Company Name from employee work history table
	 * @return List<WorkHistory>
	 */
	List<WorkHistory> sortByCompanyService();

	/**
	 * method to update Working history of an employee
	 * @param w
	 * @return String
	 */
	String updateWorkHistoryService(WorkHistory w);
}
