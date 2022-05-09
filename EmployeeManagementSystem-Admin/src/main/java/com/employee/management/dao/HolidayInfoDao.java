package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.HolidayInfo;

public interface HolidayInfoDao {
	
	/*
	 * function to get all employee holiday information details
	 */
	List<HolidayInfo> getAllDataDao();
	
	/*
	 * function to insert data into employee holiday information table
	 */
	String putDataDao(HolidayInfo h);
	
	/*
	 * function to remove data from employee holiday information table
	 */
	String removeDataById(int id);

	/*
	 * function to sort data by name from employee holiday information table
	 */
	List<HolidayInfo> sortByNameDao();

	/**
	 * Method to update holiday details of an emoloyee
	 * @param h
	 * @return
	 */
	String updateHolidayInfoDao(HolidayInfo h);
}
