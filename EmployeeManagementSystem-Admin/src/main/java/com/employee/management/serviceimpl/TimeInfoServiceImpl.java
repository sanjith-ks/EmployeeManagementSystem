package com.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.TimeInfoDao;
import com.employee.management.models.TimeInfo;
import com.employee.management.service.TimeInfoService;

@Component
public class TimeInfoServiceImpl implements TimeInfoService {
	
	/**
	 * TimeInfoDao object
	 */
	@Autowired
	TimeInfoDao tinfo;
	
	/**
	 * Method to get records of all employees time information
	 */
	@Override
	public List<TimeInfo> getAllDataService() {	
		return tinfo.getAllDataDao();
	}
	
	/**
	 * Method to get records of employee time information based on ID 
	 */
	@Override
	public TimeInfo getDataByIdService(int id) {
		return tinfo.getAllDataDao().stream().filter(i->i.getEmployee_ID_Number()==id).findAny().get();
	}
	
	/**
	 * Method to Insert data into employee time information table
	 */
	@Override
	public String putDataService(TimeInfo t) {	
		return tinfo.putDataDao(t)+t.toString();
	}
	
	/**
	 * Method to delete data into employee time information table
	 */
	@Override
	public String removeDataByIdService(int id) {
		TimeInfo t=this.getDataByIdService(id);
		return tinfo.removeDataById(id)+t.toString();
	}
	
	/**
	 * method used to sort data by Days_off and Off_hours from employee time information table
	 * @return List<TimeInfo>
	 */
	@Override
	public List<TimeInfo> sortByDaysOffService(){
		return tinfo.sortbyDaysOffDao();
	}
	
	/**
	 * method used to update time information for an employee in time information table
	 * @param t
	 * @return String
	 */
	@Override
	public String updateTimeInfoInfoService(TimeInfo t) {
		return tinfo.updateTimeInfoDao(t)+t.toString();
	}
}
