package com.employee.management.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.models.BasicDetails;
import com.employee.management.service.EmployeeBasicService;

/**
 * 
* @author Sanjith
 * @version 26-4-2022
 *
 */
@RestController
@RequestMapping(value="/hr")
public class EmployeeBasicController {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeBasicController.class);
	
	/**
	 * EmployeeBasicService object
	 */
	@Autowired
	EmployeeBasicService employeeBasicService;
	
	/**
	 * requestAllData method is used to redirect request from HR login 
	 * @param httpResponse
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value="/basicdetails")
	public String requestAllData(HttpServletResponse httpResponse) throws IOException {

		if(employeeBasicService.requestAllDataService().equals("success")){
			httpResponse.sendRedirect("/hr/getbasicdetails");
			log.debug("Rest API call is success and redirected to get result.");
			return null;
		}
		log.debug("Rest API call is failed and redirected to fallback method");
		return employeeBasicService.requestAllDataService();
	}
	
	/**
	 * getAllData is used to get all employee basic details from database
	 * @return List
	 */
	@GetMapping(value="/getbasicdetails")
	public List<BasicDetails> getAllData(){	
		log.debug("Redirected method to get result.");
		return employeeBasicService.getAllDataService();
	}
	
	/**
	 * getDataById is used to get an employee basic details from database using id number
	 * @param id
	 * @return String
	 */
	@PostMapping(value="/getbasicdetails/getbyid",produces = MediaType.APPLICATION_JSON_VALUE)
	public BasicDetails getDataById(@RequestParam int id) {
		if(employeeBasicService.getAllDataService().isEmpty())
		employeeBasicService.requestAllDataService();
		
		return employeeBasicService.getDataByIdService(id);
	}
}
