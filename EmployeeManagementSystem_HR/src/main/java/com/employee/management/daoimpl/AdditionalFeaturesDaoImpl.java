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

import com.employee.management.dao.AdditionalFeaturesDao;
import com.employee.management.models.BasicDetails;
import com.employee.management.models.TimeInfo;
import com.employee.management.models.WorkHistory;
import com.employee.management.service.EmployeeBasicService;

@Component
public class AdditionalFeaturesDaoImpl implements AdditionalFeaturesDao {

	@Autowired
	JdbcTemplate db;

	@Autowired
	EmployeeBasicService employeeBasicService;

	@Override
	public List<TimeInfo> getAllTimeInfoDao() {

		List<TimeInfo> list = db.query("select * from employee.employee_time_information", new ResultSetExtractor<List<TimeInfo>>() {

			List<TimeInfo> tlist=new ArrayList<>();

			@Override
			public List<TimeInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					TimeInfo t = new TimeInfo();
					t.setDays_Off(rs.getInt("Days_Off"));
					t.setEmployee_ID_Number(rs.getInt("Employee_ID_Number"));
					t.setExtra_Days(rs.getInt("Extra_Days"));
					t.setOff_Hours(rs.getInt("Off_Hours"));
					t.setOver_Time(rs.getInt("Days_Off"));
					t.setW_From_Date_Day(rs.getInt("w_From_Date_Day"));
					t.setW_From_Date_Month(rs.getInt("w_From_Date_Month"));
					t.setW_From_Date_Year(rs.getInt("w_From_Date_Year"));
					t.setW_To_Date_Day(rs.getInt("w_To_Date_Day"));
					t.setW_To_Date_Month(rs.getInt("w_To_Date_Month"));
					t.setW_To_Date_Year(rs.getInt("w_To_Date_Year"));
					t.setWorked_Hours(rs.getInt("Worked_Hours"));
					tlist.add(t);
				}

				return tlist;
			}
		});


		return list;
	}

	@Override
	public String getworkingDayswithTimeDao(int id) {
		try {
			TimeInfo timeinfo=getAllTimeInfoDao().stream().filter(i->i.getEmployee_ID_Number()==id).findAny().get();
			int worked_hours=timeinfo.getWorked_Hours()+timeinfo.getOver_Time()-timeinfo.getOff_Hours();
			int worked_days=25+timeinfo.getExtra_Days()-timeinfo.getDays_Off();
			String result="Employee ID: "+timeinfo.getEmployee_ID_Number()+"\nTotal Worked Hours: "
					+worked_hours+"\nTotal Worked Days: "
					+worked_days;	

			return result;

		}catch(Exception e) {
			System.out.println(e.getStackTrace());
			return "Invalid Employee ID";
		}

	}

	@Override
	public String getWorkHistoryWithNameDao(int id) {

		String sql="select e1.Employee_ID_Number,First_Name,Last_Name,Company_Name,Previous_Experience,Previous_Qualification from "
				+ "employee.employee_basic_details as e1 inner join employee.employee_working_history as e2 on "
				+ "e1.Employee_ID_Number=e2.Employee_ID_Number where e1.Employee_ID_Number="+id;
		try {
			String basic=db.query(sql, new ResultSetExtractor<String>() {

				@Override
				public String extractData(ResultSet rs) throws SQLException, DataAccessException {
					String s="";
					while(rs.next()) {
						BasicDetails b = new BasicDetails();
						b.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
						b.setFirstName(rs.getString("First_Name"));
						b.setLastName(rs.getString("Last_Name"));
						String string="Employee Id Number = "+b.getEmployeeIDNumber()+"\nFirst Name = "+b.getFirstName()+"\nLast Name = "+b.getLastName();
						s=s+string;
					}
					return s;
				}
			});

			String workhistory=db.query(sql, new ResultSetExtractor<String>() {

				@Override
				public String extractData(ResultSet rs) throws SQLException, DataAccessException {
					String s="";
					while(rs.next()) {
						WorkHistory w = new WorkHistory();
						w.setCompanyName(rs.getString("Company_Name"));
						w.setPreviousExperience(rs.getString("Previous_Experience"));
						w.setPreviousQualification(rs.getString("Previous_Qualification"));
						String string="\nCompany Name = "+w.getCompanyName()+"\nPrevious Experience = "+w.getPreviousQualification()+" Years \nPrevios Qualification = "
								+w.getPreviousQualification();
						s=s+string;
					}
					return s;
				}
			});
			return basic+workhistory;
		}catch(Exception e) {
			return "Invalid ID";
		}
	}
}
