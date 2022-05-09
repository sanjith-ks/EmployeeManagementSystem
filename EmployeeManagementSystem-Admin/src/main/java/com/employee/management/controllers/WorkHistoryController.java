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

import com.employee.management.models.WorkHistory;
import com.employee.management.service.WorkHistoryService;

/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/")
public class WorkHistoryController {
	
	private static final Logger log=LoggerFactory.getLogger(WorkHistoryController.class);
	
	@Autowired
	WorkHistoryService winfo;
	
	/**
	 * getAllData method is used to get all employee work information details from database
	 * @return List
	 */
	@GetMapping("/employee/workinfo")
	public List<WorkHistory> getAllData() {
		log.debug("User has Requested to get Worked History of all Employees.");
		return winfo.getAllDataService();
	}
	
	/**
	 * getDataById method is used to get work information of employee using id 
	 * @param id
	 * @return String
	 */
	@PostMapping("/employee/workinfo/getbyid")
	public WorkHistory getDataById(@RequestParam int id) {
		log.debug("User has Requested to get Worked History of Employee with Id={}",id);
		return winfo.getDataByIdService(id);
	}
	
	/**
	 * putData method is used to insert employee work information details into database
	 * @param w
	 * @return String
	 */
	@PutMapping(value="/admin/workinfo/insertdata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String putData(@RequestBody WorkHistory w){
		log.debug("User has Requested to insert new WorkHistory for Employee with Id={}.",w.getEmployeeIDNumber());
		return winfo.putDataService(w);
	}
	
	/**
	 * removeDataById is used to remove employee work information data from database using id
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/admin/workinfo/removedata")
	public String removeDataById(@RequestParam int id) {
	log.debug("User has REMOVED Worked History of Employee with Id={}",id);	
		return winfo.removeDataByIdService(id);	
	}
	
	/**
	 * sortByCompany is used to sort data by Company Name from employee work history table
	 * @return List<WorkHistory>
	 */
	@GetMapping("/employee/workinfo/sortbycompany")
	public List<WorkHistory> sortByCompany(){
		log.debug("User has Requested to get Worked History of all Employees SORTED BY COMPANY NAME.");
		return winfo.sortByCompanyService();
	}
	
	/**
	 * method to update Working history of an employee
	 * @param w
	 * @return String
	 */
	@PutMapping(value="/admin/workinfo/updatedata",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateWorkHistory(WorkHistory w) {
		log.debug("User has Requested to UPDATE new WorkHistory for Employee with Id={}.",w.getEmployeeIDNumber());
		return winfo.updateWorkHistoryService(w);
	}
}
