package com.employee.management.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.AdditionalFeaturesDao;
import com.employee.management.daoimpl.AdditionalFeaturesDaoImpl;
import com.employee.management.service.AdditionalFeaturesService;
import com.employee.management.service.SalaryInfoService;

@Component
public class AdditionalFeaturesServiceImpl implements AdditionalFeaturesService {
	
	Logger logger=LoggerFactory.getLogger(AdditionalFeaturesDaoImpl.class);
	@Autowired
	AdditionalFeaturesDao add;
	@Autowired
	SalaryInfoService addionalfeature;


	@Override
	public String paySalaryService(int sal,int id) {

		int payable=addionalfeature.getDataByIdService(id).getPayable_salary();
		try {

			if(payable==0) {
				throw new Exception("Salary already paid.");
				
			}
			if(payable<sal) {
				throw new Exception("Salary Exceeds Payable Salary. Pending balance is :"+payable);
			}
			return add.paySalaryDao(sal,id);
		}catch(Exception e) {
			return e.getMessage();
		}

	}

	@Override
	public String getSalaryWithNameService() {

		return add.getSalaryWithNameDao();
	}

	@Override
	public String updateSalaryService(int sal,int id) {

		return add.updateSalaryDao(sal,id);
	}

}
