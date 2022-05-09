package com.employee.management.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.models.WorkHistory;
import com.employee.management.service.WorkService;

/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/hr")
public class WorkServiceController {
	
	private static final Logger log=LoggerFactory.getLogger(WorkServiceController.class);
	
	/**
	 * WorkService object
	 */
	@Autowired
	WorkService workservice;
	
	/**
	 * getAllData is used to get all employee work history from database
	 * @return List
	 */
	@GetMapping("/workinfo")
	public List<WorkHistory> getAllData() {
		log.debug("User has requested to get all Employee's WorkHistory.");
		return workservice.getAllwork();
	}
	
	/**
	 * getDataById is used to get an employee work history from database using id number
	 * @param id
	 * @return String
	 */
	@PostMapping("/workinfo/getbyid")
	public WorkHistory getDataById(@RequestParam("id") int id) {
		log.debug("User has requested to get Employee's WorkHistory bi Id={}.",id);
		return workservice.getWorkHistoryById(id);
	}
}