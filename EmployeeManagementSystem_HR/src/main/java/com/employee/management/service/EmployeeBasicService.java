package com.employee.management.service;

import java.util.List;

import com.employee.management.models.BasicDetails;

public interface EmployeeBasicService {
	
	/*
	 * function to get all employee basic information details
	 */
	List<BasicDetails> getAllDataService();
	
	/*
	 * function to get employee basic information using id number
	 */
	BasicDetails getDataByIdService(int id);
	
	/**
	 * function to get request to all data service from admin service
	 * @return
	 */
	String requestAllDataService();
}
