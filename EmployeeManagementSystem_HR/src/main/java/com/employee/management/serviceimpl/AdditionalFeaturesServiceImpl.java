package com.employee.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.AdditionalFeaturesDao;
import com.employee.management.service.AdditionalFeaturesService;

@Component
public class AdditionalFeaturesServiceImpl implements AdditionalFeaturesService {
	
	@Autowired
	AdditionalFeaturesDao additional;
	
	@Override
	public String getworkingDayswithTimeService(int id) {
		return additional.getworkingDayswithTimeDao(id);
	}
	
	@Override
	public String getWorkHistoryWithNameService(int id) {
		return additional.getWorkHistoryWithNameDao(id);
	}
	
}
