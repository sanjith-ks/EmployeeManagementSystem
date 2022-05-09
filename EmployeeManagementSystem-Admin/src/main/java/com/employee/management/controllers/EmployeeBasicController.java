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

import com.employee.management.models.BasicDetails;
import com.employee.management.service.EmployeeBasicService;


/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/")
public class EmployeeBasicController {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeBasicController.class);
	
	@Autowired
	EmployeeBasicService ebasic;
	
	/**
	 * getAllData is used to get all employee basic details from database
	 * @return List
	 */
	@GetMapping("/employee/basicinfo")
	public List<BasicDetails> getAllData() {
		log.debug("User has requested to get all basicdetails of employees.");
		return ebasic.getAllDataService();
	}
	
	/**
	 * getDataById is used to get an employee basic details from database using id number
	 * @param id
	 * @return String
	 */
	@PostMapping("/employee/basicinfo/getbyid")
	public BasicDetails getDataById(@RequestParam("id") int id) {
		log.debug("User has requested to get basicdetails of employee with Id={}.",id);
		return ebasic.getDataByIdService(id);
	}
	
	/**
	 * putData is used to insert employee basic details data into database
	 * @param b
	 * @return String
	 */
	@PutMapping(value="/admin/basicinfo/insertdata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String putData(@RequestBody BasicDetails b){
		log.debug("User has inserted basicdetails of employee with Id={}.",b.getEmployeeIDNumber());
		return ebasic.putDataService(b);
	}
	
	/**
	 *removeDataById is used to remove data from database using id number 
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/admin/basicinfo/removedata")
	public String removeDataById(@RequestParam("id") int id) {	
		log.debug("User has removed basicdetails of employee with Id={}.",id);
		return ebasic.removeDataByIdService(id);	
	}
	
	/**
	 * sortByName is used to sort data by name from database
	 * @return List<BasicDetails>
	 */
	@GetMapping("/employee/basicinfo/sortbyname")
	public List<BasicDetails> sortByName(){
		log.debug("User has requested to get all basicdetails of employees sorted by name.");
		return ebasic.sortByNameService();
	}
	
	/**
	 * Method to update basic details for an employee
	 * @param b
	 * @return String
	 */
	@PutMapping(value="/admin/basicinfo/updatedata",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updatBasicInfo(@RequestBody BasicDetails b) {
		log.debug("User has updated basicdetails of employee with Id={}.",b.getEmployeeIDNumber());
		return ebasic.updateBasicInfoService(b);
	}
}
