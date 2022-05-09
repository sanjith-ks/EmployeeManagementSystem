package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.TimeInfo;

public interface AdditionalFeaturesDao {
	
	/**
	 * function to get working days along with working time
	 * @param id
	 * @return
	 */
	String getworkingDayswithTimeDao(int id);
	
	/**
	 * function to get all employee time information details
	 * @return List
	 */
	List<TimeInfo> getAllTimeInfoDao();
	
	/**
	 * function to get employee experience
	 * @param id
	 * @return String
	 */
	String getWorkHistoryWithNameDao(int id);
}
