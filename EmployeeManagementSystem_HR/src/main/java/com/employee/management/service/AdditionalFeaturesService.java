package com.employee.management.service;

public interface AdditionalFeaturesService {
	
	/**
	 * function to get working days along with working time
	 * @param id
	 * @return String
	 */
	String getworkingDayswithTimeService(int id);
	
	/**
	 * function to get employee experience
	 * @param id
	 * @return String
	 */
	String getWorkHistoryWithNameService(int id);
}
