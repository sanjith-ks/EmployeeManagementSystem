package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.WorkHistory;

public interface WorkHistoryDao {
	
	/*
	 * function to get all employee work history details
	 */
	List<WorkHistory> getAllDataDao();
	
	/*
	 * function to insert data into employee work history table
	 */
	String putDataDao(WorkHistory w);
	
	/*
	 * function to remove data from employee work history table
	 */
	String removeDataById(int id);

	/**
	 * method used to sort data by Company Name from employee work history table
	 * @return List<WorkHistory>
	 */
	List<WorkHistory> sortByCompanyDao();

	/**
	 * method to update Working history of an employee
	 * @param w
	 * @return String
	 */
	String updateWorkHistoryDao(WorkHistory w);
}
