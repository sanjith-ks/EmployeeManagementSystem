package com.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.HolidayInfoDao;
import com.employee.management.models.HolidayInfo;
import com.employee.management.service.HolidayInfoService;

@Component
public class HolidayInfoServiceImpl implements HolidayInfoService{
	
	/**
	 * HolidayInfoDao object
	 */
	@Autowired
	HolidayInfoDao hinfo;

	/**
	 * Method to get records of all employees holiday information
	 */
	@Override
	public List<HolidayInfo> getAllDataService() {	
		return hinfo.getAllDataDao();
	}

	/**
	 * Method to get records of employee holiday information based on ID 
	 */
	@Override
	public HolidayInfo getDataByIdService(int id) {
		return hinfo.getAllDataDao().stream().filter(i->i.getEmployee_ID_Number()==id).findAny().get();
	}
	/**
	 * Method to Insert data into employee holiday information table
	 */
	@Override
	public String putDataService(HolidayInfo h) {
		return hinfo.putDataDao(h)+h.toString();
	}

	/**
	 * Method to delete data from employee holiday information table
	 */
	@Override
	public String removeDataByIdService(int id) {
		HolidayInfo h= this.getDataByIdService(id);
		return hinfo.removeDataById(id)+h.toString();
	}
	
	/**
	 * Method to sort data by name from basic information table
	 * @return List<HolidayInfo>
	 */
	@Override
	public List<HolidayInfo> sortByNameService(){
		return hinfo.sortByNameDao();
	}
	
	/**
	 * Method to update holiday details of an emoloyee
	 * @param h
	 * @return
	 */
	@Override
	public String updateHolidayInfoService(HolidayInfo h) {
		return hinfo.updateHolidayInfoDao(h)+h.toString();
	}
}
