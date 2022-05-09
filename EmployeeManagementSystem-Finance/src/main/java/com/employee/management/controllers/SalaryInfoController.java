package com.employee.management.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.models.SalaryInfo;
import com.employee.management.service.SalaryInfoService;

/**
 * 
 * @author 
 * @version 27/04/2022
 *
 */
@RestController
@RequestMapping("/finance")
public class SalaryInfoController {
	
	Logger logger=LoggerFactory.getLogger(SalaryInfoController.class);
	
	/**
	 * SalaryInfoService object
	 */
	@Autowired
	SalaryInfoService sinfo;
	
	/**
	 * getAllData is used to get all employee salary information from database
	 * @return List
	 */
	@GetMapping("/salaryinfo")
	public List<SalaryInfo> getAllData() {
        logger.debug("Finance section has requested to retrieve all Employee's Salary Details.");
		return sinfo.getAllDataService();
	}
	
	/**
	 * getDataById is used to get an employee salary information from database using id number
	 * @param id
	 * @return String
	 */
	@PostMapping("/salaryinfo/getbyid")
	public SalaryInfo getDataById(@RequestParam("id") int id) {
		logger.debug("Finance Section has requested to retrieve an Employee's Salary Details using ID :{}",id);
		return sinfo.getDataByIdService(id);

	}
	
	/**
	 * putData is used to insert data into employee salary information table
	 * @param s
	 * @return
	 */
	@PutMapping(value="/salaryinfo/insertdata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String putData(@RequestBody SalaryInfo s){
		logger.debug("Finance Section has inserted a new Employee's Salary Details with ID :{}",s.getEmployeeIDNumber());
		return sinfo.putDataService(s);
	}
	
	/**
	 * putData is used to delete data in employee salary information table
	 * @param id
	 * @return
	 */
	@DeleteMapping("/salaryinfo/removedata")
	public String removeDataById(@RequestParam int id) {
		logger.debug("Finance Section has deleted an Employee's Salary Details using ID :{}",id);
		return sinfo.removeDataByIdService(id);		
	}
}
