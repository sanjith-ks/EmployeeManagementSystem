package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.TimeInfo;

public interface TimeInfoDao {
	
	/*
	 * function to get all employee time information details
	 */
	List<TimeInfo> getAllDataDao();
	
	/*
	 * function to insert data into employee time information table
	 */
	String putDataDao(TimeInfo t);

	/*
	 * function to remove data from employee time information table
	 */
	String removeDataById(int id);

	/**
	 * method used to sort data by Days_off and Off_hours from employee time information table
	 * @return List<TimeInfo>
	 */
	List<TimeInfo> sortbyDaysOffDao();

	/**
	 * method used to update time information for an employee in time information table
	 * @param t
	 * @return String
	 */
	String updateTimeInfoDao(TimeInfo t);
}
