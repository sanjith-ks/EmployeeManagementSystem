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

import com.employee.management.models.ContactInfo;
import com.employee.management.service.ContactInfoService;

/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 *
 */
@RestController
@RequestMapping("/")
public class ContactInfoController {
	
	private static final Logger log= LoggerFactory.getLogger(ContactInfoController.class);

	@Autowired
	ContactInfoService cinfo;
	
	/**
	 * getAllData method is used to get all contact information details from database
	 * @return List
	 */
	@GetMapping("/employee/contactinfo")
	public List<ContactInfo> getAllData() {
		log.debug("User requested to get all contact details of Employees.");
		return cinfo.getAllDataService();
	}
	
	/**
	 * getDataById method is used to get contact information of employee using id 
	 * @param id
	 * @return String
	 */
	@PostMapping("/employee/contactinfo/getbyid")
	public ContactInfo getDataById(@RequestParam int id) {
		log.debug("User requested to get contact details of Employee with Id={}.",id);
		return cinfo.getDataByIdService(id);
	}
	
	/**
	 * putData method is used to insert employee contact information details into database
	 * @param c
	 * @return String
	 */
	@PutMapping(value="/admin/contactinfo/insertdata",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String putData(@RequestBody ContactInfo c){
		log.debug("User inserted contact details to Employee with Id={}.",c.getEmployeeIDNumber());
		return cinfo.putDataService(c);
	}
	
	/**
	 * removeDataById is used to remove data from database using id
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/admin/contactinfo/removedata")
	public String removeDataById(@RequestParam int id) {
		log.debug("User has removed contact details of Employee with Id={}.",id);
		return cinfo.removeDataByIdService(id);	
	}
	/**
	 * sortByName is used to sort data by first name
	 * @return
	 */
	@GetMapping("/employee/contactinfo/sortbyname")
	public List<ContactInfo> sortByName(){
		log.debug("User requested to get sorted contact details of Employee.");
		return cinfo.sortByNameService();
	}
	
	/**
	 * updatContactInfo is used to update Contact Information for an employee
	 * @param c
	 * @return String
	 */
	@PutMapping(value="/admin/contactinfo/updatedata",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updatContactInfo(@RequestBody ContactInfo c) {
		log.debug("User has updated contact details of Employee with Id={}.",c.getEmployeeIDNumber());
		return cinfo.updateContactInfoService(c);
	}
}
