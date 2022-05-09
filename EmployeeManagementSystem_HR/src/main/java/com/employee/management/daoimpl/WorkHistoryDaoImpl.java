package com.employee.management.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.employee.management.dao.WorkHistoryDao;
import com.employee.management.models.WorkHistory;

@Component
public class WorkHistoryDaoImpl implements WorkHistoryDao{
	
	@Autowired
	JdbcTemplate db;

	@Override
	public List<WorkHistory> getallworkdetails() {
		List<WorkHistory> worklist = db.query("select * from employee.employee_working_history", new ResultSetExtractor<List<WorkHistory>>() {
			
			List<WorkHistory> slist=new ArrayList<>();

			@Override
			public List<WorkHistory> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while(rs.next()) {
					WorkHistory s = new WorkHistory();
					s.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					s.setCompanyName(rs.getString("companyName"));
					s.setEmployerName(rs.getString("employerName"));
					s.setCompanyEmployerAddress(rs.getString("companyEmployerAddress"));
					s.setCompanyEmployerCellularPhone(rs.getLong("companyEmployerCellularPhone"));
					s.setCompany_Employer_Office_Phone(rs.getLong("company_Employer_Office_Phone"));
					s.setPreviousQualification(rs.getString("previousQualification"));
					s.setPreviousExperience(rs.getString("previousExperience"));
					s.setpStartDateDay(rs.getInt("pStartDateDay"));
					s.setpStartDateMonth(rs.getInt("pStartDateMonth"));
					s.setpStartDateYear(rs.getInt("pStartDateYear"));
					s.setpEndDateDay(rs.getInt("pEndDateDay"));
					s.setpEndDateMonth(rs.getInt("pEndDateMonth"));
					s.setpEndDateYear(rs.getInt("pEndDateYear"));
					slist.add(s);
				}
				
				return slist;
			}
		});
		
		return worklist;
	}
		
	}
