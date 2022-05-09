package com.employee.management.service;

import java.util.List;

import com.employee.management.models.HolidayInfo;

public interface HolidayService {
	
	/*
	 * function to get all employee holiday information details
	 */
	List<HolidayInfo> getHolidayInfo();
	
	/*
	 * function to get employee holiday information using id number
	 */
	HolidayInfo getDataByIdService(int id);

	/**
	 * function to get request to all data service from admin service
	 * @return String
	 */
	String requestAllDataService();
}
