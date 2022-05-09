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
 * @author 
 * version 28/04/2022
 */
@RestController
@RequestMapping(value="/finance")
public class EmployeeBasicController {
	
	Logger logger=LoggerFactory.getLogger(EmployeeBasicController.class);
	
	/**
	 * EmployeeBasicService object
	 */
	@Autowired
	EmployeeBasicService employeeBasicService;
	
	/**
	 * requestAllData method is used to redirect request from FINANCE login 
	 * @param httpResponse
	 * @return Service
	 * @throws IOException
	 */
	@GetMapping(value="/basicdetails")
	public String requestAllData(HttpServletResponse httpResponse) throws IOException {

		if(employeeBasicService.requestAllDataService().equals("success")){
			httpResponse.sendRedirect("/finance/getbasicdetails");
			logger.debug("Finance section has requested Employee Basic Details of Admin Service and redirected to another path to get all basic details.");
			return null;
		}
		logger.debug("Finance section has requested Employee Basic Details of Admin Service and redirected to fallback method as admin Rest API Call FAILED.");
		return employeeBasicService.requestAllDataService();
	}
	
	/**
	 * getAllData is used to get all employee basic details from database
	 * @return List
	 */
	@GetMapping(value="/getbasicdetails")
	public List<BasicDetails> getAllData(){
		logger.debug("Redirected method to return all basic details of Employees");
		return employeeBasicService.getAllDataService();
	}
	
	/**
	 * getDataById is used to get an employee basic details from database using id number
	 * @param id
	 * @return String
	 */
	@PostMapping(value="/getbasicdetails/getbyid",produces = MediaType.APPLICATION_JSON_VALUE)
	public BasicDetails getDataById(@RequestParam("id") int id) {
		logger.debug("Finance Section has requested to get for Employee with ID :{}",id);
		employeeBasicService.requestAllDataService();
		return employeeBasicService.getDataByIdService(id);
	}
}
