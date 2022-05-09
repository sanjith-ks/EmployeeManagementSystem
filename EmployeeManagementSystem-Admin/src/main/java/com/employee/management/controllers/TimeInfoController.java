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

import com.employee.management.models.TimeInfo;
import com.employee.management.service.TimeInfoService;

/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/")
public class TimeInfoController {
	
	private static final Logger log=LoggerFactory.getLogger(TimeInfoController.class);
	
	@Autowired
	TimeInfoService tinfo;
	
	/**
	 * getAllData method is used to get all employee time information details from database
	 * @return List
	 */
	@GetMapping("/employee/timeinfo")
	public List<TimeInfo> getAllData() {
		log.debug("User has Requested to get all worked time information for all employees.");
		return tinfo.getAllDataService();
	}
	
	/**
	 * getDataById method is used to get time information of employee using id 
	 * @param id
	 * @return String
	 */
	@PostMapping("/employee/timeinfo/getbyid")
	public TimeInfo getDataById(@RequestParam int id) {
		log.debug("User has Requested to get worked time information for employee with Id={}.",id);
		return tinfo.getDataByIdService(id);
	}
	
	/**
	 * putData method is used to insert employee time information details into database
	 * @param t
	 * @return String
	 */
	@PutMapping(value="/admin/timeinfo/insertdata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String putData(@RequestBody TimeInfo t){
		log.debug("User has requested to insert new worked time information for Employee with Id={}",t.getEmployee_ID_Number());
		return tinfo.putDataService(t);
	}
	
	/**
	 * removeDataById is used to remove employee time information data from database using id
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/admin/timeinfo/removedata")
	public String removeDataById(@RequestParam int id) {	
		log.debug("User has REMOVED worked time information for employee with Id={}.",id);
		return tinfo.removeDataByIdService(id);	
	}
	
	/**
	 * sortByDaysOff is used to sort data by Days_off and Off_hours from employee time information table
	 * @return List<TimeInfo>
	 */
	@GetMapping("/employee/timeinfo/sortbydaysoff")
	public List<TimeInfo> sortByDaysOff(){
		log.debug("User has Requested to get all worked time information for all employees SORTED BY DAYS OFF.");
		return tinfo.sortByDaysOffService();
	}
	
	/**
	 * method used to update time information for an employee in time information table
	 * @param t
	 * @return String
	 */
	@PutMapping(value="/admin/timeinfo/updatedata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateTimeInfoInfoD(TimeInfo t) {
		log.debug("User has requested to update worked time information for Employee with Id={}",t.getEmployee_ID_Number());
		return tinfo.updateTimeInfoInfoService(t);
	}
}
