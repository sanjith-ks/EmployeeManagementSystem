package com.employee.management.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.service.AdditionalFeaturesService;

/**
 * 
 * @author Sanjith
 * @version 26-4-2022
 *
 */
@RestController
@RequestMapping(value="/hr")
public class AdditionalFeaturesController {
	
	Logger log=LoggerFactory.getLogger(AdditionalFeaturesController.class);
	
	/**
	 * AdditionalFeaturesService object
	 */
	@Autowired
	AdditionalFeaturesService additional;
	
	/**
	 * getworkingDayswithTime method is used to get working time along with working days
	 * @param id
	 * @return String
	 */
	@PostMapping("/getworkingtime")
	public String getworkingDayswithTime(@RequestParam("id") int id) {
		log.debug("User has requested to get working time of employee with Id="+id);
		return additional.getworkingDayswithTimeService(id);
	}
	
	/**
	 * getWorkHistoryWithName method is used to get employee work experience
	 * @param id
	 * @return String
	 */
	@PostMapping("/getexperience")
	public String getWorkHistoryWithName(@RequestParam("id")int id) {
		log.debug("User has requested to get working history of employee with Id="+id);
		return additional.getWorkHistoryWithNameService(id);
	}	
}
