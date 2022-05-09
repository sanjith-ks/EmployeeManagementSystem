package com.employee.management.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.models.HolidayInfo;
import com.employee.management.service.HolidayService;

/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/hr")
public class HolidayServiceController {
	
	private static final Logger log=LoggerFactory.getLogger(HolidayServiceController.class);
	
	/**
	 * 	HolidayService object
	 */
	@Autowired
	HolidayService holidayservice;

	/**
	 * requestAllData method is used to redirect request from HR login 
	 * @param httpResponse
	 * @return Service 
	 * @throws IOException
	 */
	@GetMapping(value="/holidayinfo")
	public String requestAllData(HttpServletResponse httpResponse) throws IOException {

		if(holidayservice.requestAllDataService().equals("success")){
			httpResponse.sendRedirect("/hr/getholidayinfo");
			log.debug("Human Resource Service has successfully called Admin REST API and redirected to get the result");
			return null;
		}
		log.debug("Human Resource Service has FAILED to access Admin REST API & fallbackmethod is executed.");
		return holidayservice.requestAllDataService();
	}
	
	/**
	 * getAllData is used to get all employee holiday information from database
	 * @return List
	 */
	@GetMapping(value="/getholidayinfo")
	public List<HolidayInfo> getAllData(){	
		log.debug("redirected method to get all employee's holiday info.");
		return holidayservice.getHolidayInfo();
	}
	
	/**
	 * getDataById is used to get an employee holiday information from database using id number
	 * @param id
	 * @return String
	 */
	@PostMapping("/holidayinfo/getbyid")
	public HolidayInfo getDataById(@RequestParam("id")int id) {
		if(holidayservice.getHolidayInfo().isEmpty()) {
		holidayservice.requestAllDataService();
		log.debug("Human Resource Service has successfully called Admin REST API.");
		}
		log.debug("User has requested to get holiday info of employee with Id={}.",id);
		return holidayservice.getDataByIdService(id);
	}
}
