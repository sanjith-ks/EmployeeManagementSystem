package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.HolidayInfo;

public interface HolidayInfoDao {
	
	/*
	 * function to get all employee holiday information details
	 */
	List<HolidayInfo> getallHolidayInfo();
}
