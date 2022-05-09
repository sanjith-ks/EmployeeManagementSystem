package com.employee.management.dao;

import java.util.List;

import com.employee.management.models.WorkHistory;

public interface WorkHistoryDao {
	
	/*
	 * function to get all employee work history details
	 */
	List<WorkHistory> getallworkdetails();
}
