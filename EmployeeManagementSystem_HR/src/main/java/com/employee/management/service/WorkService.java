package com.employee.management.service;

import java.util.List;
import com.employee.management.models.WorkHistory;

public interface WorkService  {
	
	/*
	 * function to get all employee work history details
	 */
	List<WorkHistory> getAllwork();
	
	/*
	 * function to get employee work history using id number
	 */
	WorkHistory getWorkHistoryById(int id);
}
