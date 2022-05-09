package com.employee.management.service;

import java.util.List;

import com.employee.management.models.HolidayInfo;

public interface HolidayInfoService {
	
	/*
	 * function to get all employee holiday information details
	 */
	List<HolidayInfo> getAllDataService();
	
	/*
	 * function to get employee holiday information using id number
	 */
	HolidayInfo getDataByIdService(int id);
	
	/*
	 * function to insert data into employee holiday information table
	 */
	String putDataService(HolidayInfo h);
	
	/*
	 * function to remove data from employee holiday information table
	 */
	String removeDataByIdService(int id);

	/**
	 * Method to sort data by name from basic information table
	 * @return List<HolidayInfo>
	 */
	List<HolidayInfo> sortByNameService();

	/**
	 * Method to update holiday details of an emoloyee
	 * @param h
	 * @return
	 */
	String updateHolidayInfoService(HolidayInfo h);


}
