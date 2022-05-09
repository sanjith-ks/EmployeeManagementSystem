package com.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.SalaryInfoDao;
import com.employee.management.models.SalaryInfo;
import com.employee.management.service.SalaryInfoService;

@Component
public class SalaryInfoServiceImpl implements SalaryInfoService {
	
	/**
	 * SalaryInfoDao object
	 */
	@Autowired
	SalaryInfoDao sinfo;

	/**
	 * Method to get records of all employees salary information
	 */
	@Override
	public List<SalaryInfo> getAllDataService() {		
		return sinfo.getAllDataDao();
	}

	/**
	 * Method to get records of employee salary information based on ID 
	 */
	@Override
	public SalaryInfo getDataByIdService(int id) {
		return sinfo.getAllDataDao().stream().filter(i->i.getEmployeeIDNumber()==id).findAny().get();
	}
	
	/**
	 * Method to Insert data into employee salary information table
	 */
	@Override
	public String putDataService(SalaryInfo s) {		
		return sinfo.putDataDao(s)+s.toString();
	}

	/**
	 * Method to delete data into employee salary information table
	 */
	@Override
	public String removeDataByIdService(int id) {
		SalaryInfo s= this.getDataByIdService(id);
		return sinfo.removeDataById(id)+s.toString();
	}

	/**
	 * function used to sort by name from employee salary information table
	 * @return List<SalaryInfo>
	 */
	@Override
	public List<SalaryInfo> sortBySalaryService() {
		
		return sinfo.sortBySalaryDao();
	}
	
	/**
	 * Method to update salary information of an employee
	 * @param s
	 * @return String
	 */
	@Override
	public String updateSalaryInfoService(SalaryInfo s) {
		return sinfo.updateSalaryInfoDao(s)+s.toString();
	}
}
