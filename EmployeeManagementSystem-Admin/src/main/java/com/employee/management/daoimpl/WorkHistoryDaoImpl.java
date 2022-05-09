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
public class WorkHistoryDaoImpl implements WorkHistoryDao {

	@Autowired
	JdbcTemplate db;

	@Override
	public List<WorkHistory> getAllDataDao() {



		List<WorkHistory> worklist = db.query("select * from employee.employee_working_history", new ResultSetExtractor<List<WorkHistory>>() {

			List<WorkHistory> wlist=new ArrayList<>();

			@Override
			public List<WorkHistory> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					WorkHistory w = new WorkHistory();
					w.setCompany_Employer_Office_Phone(rs.getLong("Company_Employer_Office_Phone"));
					w.setCompanyEmployerAddress(rs.getString("Company_Employer_Address"));
					w.setCompanyEmployerCellularPhone(rs.getLong("Company_Employer_Cellular_Phone"));
					w.setCompanyName(rs.getString("Company_Name"));
					w.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					w.setEmployerName(rs.getString("Employer_Name"));
					w.setpEndDateDay(rs.getInt("p_End_Date_Day"));
					w.setpEndDateMonth(rs.getInt("p_End_Date_Month"));
					w.setpEndDateYear(rs.getInt("p_End_Date_Year"));
					w.setPreviousExperience(rs.getString("Previous_Experience"));
					w.setPreviousQualification(rs.getString("Previous_Qualification"));
					w.setpStartDateDay(rs.getInt("p_Start_Date_Day"));
					w.setpStartDateMonth(rs.getInt("p_Start_Date_Month"));
					w.setpStartDateYear(rs.getInt("p_Start_Date_Year"));

					wlist.add(w);
				}

				return wlist;
			}
		});

		return worklist;
	}

	@Override
	public String putDataDao(WorkHistory w) {
		String result="WorkingHistory with ID number "+w.getEmployeeIDNumber()+" inserted Successfully.";
		String sql="insert into employee.employee_working_history(Employee_ID_Number,Company_Name,Employer_Name,Company_Employer_Address,Company_Employer_Cellular_Phone,Company_Employer_Office_Phone,"
				+ "Previous_Qualification,Previous_Experience,p_Start_Date_Day,p_Start_Date_Month,p_Start_Date_Year,p_End_Date_Day,p_End_Date_Month,p_End_Date_Year)"
				+ " values("+w.getEmployeeIDNumber()+",'"+w.getCompanyName()+"','"+w.getEmployerName()+"','"+w.getCompanyEmployerAddress()+"',"+w.getCompanyEmployerCellularPhone()+","+w.getCompany_Employer_Office_Phone()+",'"
				+ w.getPreviousQualification()+"','"+w.getPreviousExperience()+"',"+w.getpStartDateDay()+","+w.getpStartDateMonth()+","+w.getpStartDateYear()+","+w.getpEndDateDay()
				+","+w.getpEndDateMonth()+","+w.getpEndDateYear()+")";
		try {
			db.execute(sql);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			result="Data insertion failed";
		}
		return result;
	}

	@Override
	public String removeDataById(int id) {
		String result="WorkingHistory with ID Number "+id+" has been deleted Successfully.";
		String sql= "delete from employee.employee_working_history where Employee_ID_Number="+id;
		try {
			db.execute(sql);
		}
		catch(Exception e) {
			result="Data deletion failed.";
		}
		return result;
	}
	
	@Override
	public List<WorkHistory> sortByCompanyDao(){
		List<WorkHistory> worklist = db.query("select * from employee.employee_working_history order by Company_Name,Previous_Experience", new ResultSetExtractor<List<WorkHistory>>() {

			List<WorkHistory> wlist=new ArrayList<>();

			@Override
			public List<WorkHistory> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					WorkHistory w = new WorkHistory();
					w.setCompany_Employer_Office_Phone(rs.getLong("Company_Employer_Office_Phone"));
					w.setCompanyEmployerAddress(rs.getString("Company_Employer_Address"));
					w.setCompanyEmployerCellularPhone(rs.getLong("Company_Employer_Cellular_Phone"));
					w.setCompanyName(rs.getString("Company_Name"));
					w.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					w.setEmployerName(rs.getString("Employer_Name"));
					w.setpEndDateDay(rs.getInt("p_End_Date_Day"));
					w.setpEndDateMonth(rs.getInt("p_End_Date_Month"));
					w.setpEndDateYear(rs.getInt("p_End_Date_Year"));
					w.setPreviousExperience(rs.getString("Previous_Experience"));
					w.setPreviousQualification(rs.getString("Previous_Qualification"));
					w.setpStartDateDay(rs.getInt("p_Start_Date_Day"));
					w.setpStartDateMonth(rs.getInt("p_Start_Date_Month"));
					w.setpStartDateYear(rs.getInt("p_Start_Date_Year"));

					wlist.add(w);
				}
			return wlist;
			}
		});

		return worklist;
	}
	
	@Override
	public String updateWorkHistoryDao(WorkHistory w) {
		String result="Data updated Successfully.";
		String sql="update employee.employee_working_history set Company_Name=?,Employer_Name=?,Company_Employer_Address=?,Company_Employer_Cellular_Phone=?,Company_Employer_Office_Phone=?,"
			+"Previous_Qualification=?,Previous_Experience=?,p_Start_Date_Day=?,p_Start_Date_Month=?,p_Start_Date_Year=?,p_End_Date_Day=?,p_End_Date_Month=?,p_End_Date_Year=?"
				+ " where Employee_ID_Number=?";
		int records=0;
		try {
			records=db.update(sql,w.getCompanyName(),w.getEmployerName(),w.getCompanyEmployerAddress(),w.getCompanyEmployerCellularPhone(),w.getCompany_Employer_Office_Phone(),
					w.getPreviousQualification(),w.getPreviousExperience(),w.getpStartDateDay(),w.getpStartDateMonth(),w.getpStartDateYear(),
					w.getpStartDateDay(),w.getpStartDateMonth(),w.getpStartDateYear(),w.getpEndDateDay(),w.getpEndDateMonth(),w.getpEndDateYear(),w.getEmployeeIDNumber());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			result="Data insertion failed. Check Id Number";
		}
		return result+records+" records has changed.";
	}



}
