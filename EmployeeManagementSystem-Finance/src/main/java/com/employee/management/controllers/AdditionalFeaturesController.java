package com.employee.management.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.service.AdditionalFeaturesService;

/**
 * 
 * @author 
 * version 28/04/2022
 */
@RestController
@RequestMapping(value="/finance")
public class AdditionalFeaturesController {
	
	Logger logger=LoggerFactory.getLogger(AdditionalFeaturesController.class);
	
	/**
	 * AdditionalFeaturesService object
	 */
	@Autowired
	AdditionalFeaturesService add;
	
	/**
	 * pay salary method is used to insert data into employee salary table
	 * @param sal
	 * @param id
	 * @return
	 */
	@PostMapping("/salaryinfo/paysalary")
	public String paysalary(@RequestParam("sal") int sal,@RequestParam("id") int id) {
		logger.debug("Finance Section has requested Paid Salary to Employee with ID :{}",id);
		return add.paySalaryService(sal, id);
	}
	
	/**
	 * getSalaryWithName is used to get salary details of employee along with name
	 * @return String
	 */
	@GetMapping(value="/salaryinfo/getwithname")
	public String getSalaryWithName(){
		logger.debug("Finance Section has requested for all Employees with Name and Salary Details");
		return add.getSalaryWithNameService();
	}
	
	/**
	 * getSalaryWithName is used to update salary details of employee along with name
	 * @return String
	 */
	@PostMapping(value="/salaryinfo/updatesalary")
	public String updateSalary(@RequestParam("sal")int sal,@RequestParam("id") int id ) {
		logger.debug("Finance Section has requested to update Salary {} to Employee with ID :{}",sal,id);
		return add.updateSalaryService(sal,id);	
	}
}
