package com.employee.management.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.SalaryInfoDao;
import com.employee.management.models.SalaryInfo;
import com.employee.management.service.SalaryInfoService;

@Component
public class SalaryInfoServiceImpl implements SalaryInfoService {

	Logger logger = LoggerFactory.getLogger(SalaryInfoServiceImpl.class);

	@Autowired
	SalaryInfoDao sinfo;

	@Override
	public List<SalaryInfo> getAllDataService() {

		return sinfo.getAllDataDao();
	}

	@Override
	public SalaryInfo getDataByIdService(int id) {
		try {
			return sinfo.getAllDataDao().stream().filter(i->i.getEmployeeIDNumber()==id).findAny().get();

		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Invalid ID");
			return null;
		}
		
	}

	@Override
	public String putDataService(SalaryInfo s) {

		return sinfo.putDataDao(s)+s.toString();
	}

	@Override
	public String removeDataByIdService(int id) {

		SalaryInfo s= this.getDataByIdService(id);
		return sinfo.removeDataById(id)+s.toString();
	}

}
