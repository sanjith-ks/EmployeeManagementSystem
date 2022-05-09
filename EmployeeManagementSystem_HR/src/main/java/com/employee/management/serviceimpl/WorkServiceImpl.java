package com.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.dao.WorkHistoryDao;
import com.employee.management.models.WorkHistory;
import com.employee.management.service.WorkService;

@Component
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	WorkHistoryDao workdao;

	@Override
	public List<WorkHistory> getAllwork() {
		return workdao.getallworkdetails();
	}

	@Override
	public WorkHistory getWorkHistoryById(int id) {
		return workdao.getallworkdetails().stream().filter(i->i.getEmployeeIDNumber()==id).findAny().get();
	}

}
