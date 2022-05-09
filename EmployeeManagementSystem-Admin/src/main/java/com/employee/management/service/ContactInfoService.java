package com.employee.management.service;

import java.util.List;

import com.employee.management.models.ContactInfo;

public interface ContactInfoService {
	
	/*
	 * function to get all employee contact information details
	 */
	List<ContactInfo> getAllDataService();
	
	/*
	 * function to get employee contact information using id number
	 */
	ContactInfo getDataByIdService(int id);
	
	/*
	 * function to insert data into employee contact information table
	 */
	String putDataService(ContactInfo c);
	
	/*
	 * function to remove data from employee contact information table
	 */
	String removeDataByIdService(int id);
	
	/*
	 * function to sort data bye name from employee contact information table
	 */
	List<ContactInfo> sortByNameService();

	/**
	 * Method used to update Contact Information of Employees
	 * @param c
	 * @return String
	 */
	String updateContactInfoService(ContactInfo c);
}
