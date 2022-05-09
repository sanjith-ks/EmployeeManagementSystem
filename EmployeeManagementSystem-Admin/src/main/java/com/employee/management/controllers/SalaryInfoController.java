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
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/")
public class SalaryInfoController {
	
	private static final Logger log=LoggerFactory.getLogger(SalaryInfoController.class);
	
	@Autowired
	SalaryInfoService sinfo;
	
	/**
	 * getAllData method is used to get all salary information details from database
	 * @return List
	 */
	@GetMapping("/employee/salaryinfo")
	public List<SalaryInfo> getAllData() {
		log.debug("User has requested to get all salary details of employees.");
		return sinfo.getAllDataService();
	}
	
	/**
	 * getDataById method is used to get salary information of employee using id 
	 * @param id
	 * @return String
	 */
	@PostMapping("/employee/salaryinfo/getbyid")
	public SalaryInfo getDataById(@RequestParam("id") int id) {
		log.debug("User has requested salary details of employee with Id={}",id);
		return sinfo.getDataByIdService(id);
	}
	
	/**
	 * putData method is used to insert employee salary information details into database
	 * @param s
	 * @return String
	 */
	@PutMapping(value="/admin/salaryinfo/insertdata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String putData(@RequestBody SalaryInfo s){
		log.debug("User has inserted Salary details to Employee with Id={}",s.getEmployeeIDNumber());
		return sinfo.putDataService(s);
	}
	
	/**
	 * removeDataById is used to remove salary information details of employee from database using id
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/admin/salaryinfo/removedata")
	public String removeDataById(@RequestParam int id) {	
		log.debug("User has removed salary details of employee with Id={}",id);
		return sinfo.removeDataByIdService(id);	
	}
	
	/**
	 * sortBySalary is used to fetch salary information as sorted by salary
	 * @return List<SalaryInfo>
	 */
	@GetMapping("/employee/salaryinfo/sortbysalary")
	public List<SalaryInfo> sortBySalary(){
		log.debug("User has requested to get all salary details of employees sorted by Monthly Salary.");
		return sinfo.sortBySalaryService();
	}
	
	/**
	 * updateSalaryInfo is used to update salary information of an employee
	 * @param s
	 * @return String
	 */
	@PutMapping(value="/admin/salaryinfo/updatedata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateSalaryInfo(SalaryInfo s) {
		log.debug("User has updated Salary details to Employee with Id={}",s.getEmployeeIDNumber());
		return sinfo.updateSalaryInfoService(s);
	}
}
