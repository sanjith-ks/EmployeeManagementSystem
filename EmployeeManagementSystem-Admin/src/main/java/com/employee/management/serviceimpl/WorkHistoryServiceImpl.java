package com.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.WorkHistoryDao;
import com.employee.management.models.WorkHistory;
import com.employee.management.service.WorkHistoryService;

@Component
public class WorkHistoryServiceImpl implements WorkHistoryService {
	
	/**
	 * WorkHistoryDao object
	 */
	@Autowired
	WorkHistoryDao winfo;
	
	/**
	 * Method to get records of all employees work history information
	 */
	@Override
	public List<WorkHistory> getAllDataService() {
		return winfo.getAllDataDao();
	}
	
	/**
	 * Method to get records of employee work history information based on ID 
	 */
	@Override
	public WorkHistory getDataByIdService(int id) {
		return winfo.getAllDataDao().stream().filter(i->i.getEmployeeIDNumber()==id).findAny().get();
	}
	
	/**
	 * Method to Insert data into employee work history information table
	 */
	@Override
	public String putDataService(WorkHistory w) {
		return winfo.putDataDao(w)+w.toString();
	}
	
	/**
	 * Method to delete data into employee work history information table
	 */
	@Override
	public String removeDataByIdService(int id) {	
		WorkHistory w=this.getDataByIdService(id);
		return winfo.removeDataById(id)+w.toString();
	}
	
	/**
	 * method used to sort data by Company Name from employee work history table
	 * @return List<WorkHistory>
	 */
	@Override
	public List<WorkHistory> sortByCompanyService(){
		return winfo.sortByCompanyDao();
	}
	
	/**
	 * method to update Working history of an employee
	 * @param w
	 * @return String
	 */
	@Override
	public String updateWorkHistoryService(WorkHistory w) {
		return winfo.updateWorkHistoryDao(w)+w.toString();
		
	}
}
