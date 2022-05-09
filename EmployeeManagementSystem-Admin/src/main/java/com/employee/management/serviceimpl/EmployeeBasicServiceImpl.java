package com.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.EmployeeBasicDao;
import com.employee.management.models.BasicDetails;
import com.employee.management.service.EmployeeBasicService;

@Component
public class EmployeeBasicServiceImpl implements EmployeeBasicService {
	
	/**
	 * EmployeeBasicDao object
	 */
	@Autowired
	EmployeeBasicDao ebasic;
	

	/**
	 * Method to get records of all employees basic information
	 */
	@Override
	public List<BasicDetails> getAllDataService() {
		return ebasic.getAllDataDao();
	}

	/**
	 * Method to get records of employee basic information based on ID 
	 */
	@Override
	public BasicDetails getDataByIdService(int id) {
		
		return ebasic.getAllDataDao().stream().filter(i->i.getEmployeeIDNumber()==id).findAny().get();
	}

	/**
	 * Method to Insert data into employee basic information table
	 */
	@Override
	public String putDataService(BasicDetails b) {
		
		return ebasic.putDataDao(b)+b.toString();
	}
	
	/**
	 * Method to delete data into employee basic information table
	 */
	@Override
	public String removeDataByIdService(int id) {
		BasicDetails b=this.getDataByIdService(id);
		return ebasic.removeDataByIdDao(id)+b.toString();
	}
	
	/*
	 *  function to sort data by name from employee basic information table
	 */
	@Override
	public List<BasicDetails> sortByNameService(){
		return ebasic.sortByNameDao();
	}

	/**
	 * Method to update basic details for an employee
	 * @param b
	 * @return String
	 */
	@Override
	public String updateBasicInfoService(BasicDetails b) {
		return ebasic.updateBasicInfoDao(b)+b.toString();
	}
}
