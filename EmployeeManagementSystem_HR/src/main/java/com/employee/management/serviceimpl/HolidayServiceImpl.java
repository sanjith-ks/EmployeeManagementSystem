package com.employee.management.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.employee.management.models.HolidayInfo;
import com.employee.management.service.HolidayService;

import io.github.resilience4j.retry.annotation.Retry;

@Component
public class HolidayServiceImpl implements HolidayService{
	
	@Autowired
	RestTemplate rest;

	List<HolidayInfo> list= new ArrayList<>();
		
	@Retry(name = "holidayService",fallbackMethod ="getAllDataService_Fallback")	
	public String requestAllDataService() {
		System.out.println("retrying...");
		list = rest.exchange("http://ADMIN/employee/holidayinfo",
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<HolidayInfo>>() {
				}).getBody();
		return "success";
	}
	
	@Override
	public List<HolidayInfo> getHolidayInfo(){
		return list;
	}

	public String getAllDataService_Fallback(Exception e) {
		return "SERVICE FOR EMPLOYEE MANAGEMENT IS DOWN... PLEASE TRY AFTER SOME TIME..!";
	}


	@Override
	public HolidayInfo getDataByIdService(int id) {
		
		return list.stream().filter(i->i.getEmployee_ID_Number()==id).findAny().get();
	}
}
