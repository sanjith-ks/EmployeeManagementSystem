package com.employee.management.service;

import java.util.List;

import com.employee.management.models.TimeInfo;

public interface TimeInfoService {
	
	/*
	 * function to get all employee time information details
	 */
	List<TimeInfo> getAllDataService();
	
	/*
	 * function to get employee time information using id number
	 */
	TimeInfo getDataByIdService(int id);
	
	/*
	 * function to insert data into employee time information table
	 */
	String putDataService(TimeInfo t);
	
	/*
	 * function to remove data from employee time information table
	 */
	String removeDataByIdService(int id);

	/**
	 * method used to sort data by Days_off and Off_hours from employee time information table
	 * @return List<TimeInfo>
	 */
	List<TimeInfo> sortByDaysOffService();

	/**
	 * method used to update time information for an employee in time information table
	 * @param t
	 * @return String
	 */
	String updateTimeInfoInfoService(TimeInfo t);
}
