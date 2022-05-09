package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.SalaryInfo;

public interface SalaryInfoDao {
	
	/*
	 * function to get all employee salary information details
	 */
	List<SalaryInfo> getAllDataDao();
	
	/*
	 * function to insert data into employee salary information table
	 */
	String putDataDao(SalaryInfo s);
	
	/*
	 * function to remove data from employee salary information table
	 */
	String removeDataById(int id);

	/**
	 * function to return sorted by name list from employee salary information table
	 * @return List<SalaryInfo
	 */
	List<SalaryInfo> sortBySalaryDao();

	/**
	 * Method to update salary information of an employee
	 * @param s
	 * @return String
	 */
	String updateSalaryInfoDao(SalaryInfo s);
}
