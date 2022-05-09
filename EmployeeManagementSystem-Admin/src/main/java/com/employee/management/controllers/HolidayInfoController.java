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

import com.employee.management.models.HolidayInfo;
import com.employee.management.service.HolidayInfoService;

/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/")
public class HolidayInfoController {
	
	private static final Logger log=LoggerFactory.getLogger(HolidayInfoController.class);
	
	@Autowired
	HolidayInfoService hinfo;
	
	/**
	 * getAllData is used to get all employee holiday information from database
	 * @return List
	 */
	@GetMapping("/employee/holidayinfo")
	public List<HolidayInfo> getAllData() {
		log.debug("User has requested to get all holiday details of employees.");
		return hinfo.getAllDataService();
	}
	
	/**
	 * getDataById is used to get an employee holiday information from database using id number
	 * @param id
	 * @return String
	 */
	@PostMapping("/employee/holidayinfo/getbyid")
	public HolidayInfo getDataById(@RequestParam("id") int id) {
		log.debug("User has requested to get holiday details of employee by Id={}.",id);
		return hinfo.getDataByIdService(id);
	}
	
	/**
	 * putData is used to insert employee holiday information data into database
	 * @param h
	 * @return String
	 */
	@PutMapping(value="/admin/holidayinfo/insertdata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String putData(@RequestBody HolidayInfo h){
		log.debug("User has inserted holiday details of employee with Id={}.",h.getEmployee_ID_Number());
		return hinfo.putDataService(h);
	}
	
	/**
	 *removeDataById is used to remove data from database using id number 
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/admin/holidayinfo/removedata")
	public String removeDataById(@RequestParam int id) {	
		log.debug("User has removed holiday details of employee by Id={}.",id);
		return hinfo.removeDataByIdService(id);	
	}
	
	/**
	 * sortByName is used to fetch holiday information as sorted by holidays
	 * @return List<HolidayInfo>
	 */
	@GetMapping("/employee/holidayinfo/sortbyholiday")
	public List<HolidayInfo> sortByName(){
		log.debug("User has requested to get all holiday details of employees sorted by holiday name.");
		return hinfo.sortByNameService();
	}
	
	/**
	 * updateHolidayInfo is used to update holiday details of an emoloyee
	 * @param h
	 * @return
	 */
	@PutMapping(value="/admin/holidayinfo/updatedata",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateHolidayInfo(HolidayInfo h) {
		log.debug("User has updated holiday details of employee with Id={}.",h.getEmployee_ID_Number());
		return hinfo.updateHolidayInfoService(h);
	}
}
