package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.ContactInfo;

public interface ContactInfoDao {
	
	/*
	 * function to get all employee contact information details
	 */
	List<ContactInfo> getAllDataDao();
	
	/*
	 * function to insert data into employee contact information table
	 */
	String putDataDao(ContactInfo c);
	
	/*
	 * function to remove data from employee contact information table
	 */
	String removeDataById(int id);

	/*
	 * function to sort data by name from employee contact information table
	 */
	List<ContactInfo> sortByNameDao();

	/**
	 * Method used to update Contact Information of Employees
	 * @param c
	 * @return String
	 */
	String updateContactInfoDao(ContactInfo c);
}
