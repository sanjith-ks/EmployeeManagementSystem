package com.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.ContactInfoDao;
import com.employee.management.models.ContactInfo;
import com.employee.management.service.ContactInfoService;

@Component
public class ContactInfoServiceImpl implements ContactInfoService {
	
	/**
	 * ContactInfoDao object
	 */
	@Autowired
	ContactInfoDao cinfo;
	
	/**
	 * Method to get records of all employees contact information
	 */
	@Override
	public List<ContactInfo> getAllDataService() {
		return cinfo.getAllDataDao();
	}
	
	/**
	 * Method to get records of employee contact information based on ID 
	 */
	@Override
	public ContactInfo getDataByIdService(int id) {
		return cinfo.getAllDataDao().stream().filter(i->i.getEmployeeIDNumber()==id).findAny().get();
	}

	/**
	 * Method to Insert data into employee contact information table
	 */
	@Override
	public String putDataService(ContactInfo c) {	
		return cinfo.putDataDao(c)+c.toString();
	}

	/**
	 * Method to delete data in employee contact information table
	 */
	@Override
	public String removeDataByIdService(int id) {	
		ContactInfo c= this.getDataByIdService(id);
		return cinfo.removeDataById(id)+c.toString();
	}	
	

	/*
	 * Method to sort data bye name from employee contact information table
	 */
	@Override
	public List<ContactInfo> sortByNameService(){
		return cinfo.sortByNameDao();
	}
	
	/**
	 * Method used to update Contact Information of Employees
	 * @param c
	 * @return String
	 */
	@Override
	public String updateContactInfoService(ContactInfo c) {
		return cinfo.updateContactInfoDao(c)+c.toString();
	}
}
