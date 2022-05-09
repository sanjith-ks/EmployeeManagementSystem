package com.employee.management.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.management.models.BasicDetails;
import com.employee.management.service.EmployeeBasicService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeBasicServiceImpl implements EmployeeBasicService {

	@Autowired
	RestTemplate rest;

	public static final String BASEPATH="http://ADMIN/employee/basicinfo";
	List<BasicDetails> list= new ArrayList<>();
	
	@Override
	@HystrixCommand(fallbackMethod = "getAllDataService_Fallback")
	public String requestAllDataService() {
		list = rest.exchange(BASEPATH,
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<BasicDetails>>() {
				}).getBody();
		return "success";
	}
	
	public List<BasicDetails> getAllDataService(){
		return list;
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public String getAllDataService_Fallback() {
		return "SERVICE FOR EMPLOYEE MANAGEMENT IS DOWN... PLEASE TRY AFTER SOME TIME..!";
	}


	@Override
	public BasicDetails getDataByIdService(int id) {	
		return list.stream().filter(i->i.getEmployeeIDNumber()==id).findAny().get();
	}

}
