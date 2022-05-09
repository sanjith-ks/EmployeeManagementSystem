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

import com.employee.management.dao.HolidayInfoDao;
import com.employee.management.models.HolidayInfo;

@Component
public class HolidayInfoDaoImpl implements HolidayInfoDao {
	
	@Autowired
	JdbcTemplate temp;

	@Override
	public List<HolidayInfo> getAllDataDao() {
		 List<HolidayInfo> list = temp.query("select * from employee.employee_holiday_information", new ResultSetExtractor<List<HolidayInfo>>() {
				
				List<HolidayInfo> hlist=new ArrayList<>();

				@Override
				public List<HolidayInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					while(rs.next()) {
						HolidayInfo h = new HolidayInfo();
						h.setEmployee_ID_Number(rs.getInt("Employee_ID_Number"));
						h.setH_From_Date_Day(rs.getInt("h_From_Date_Day"));
						h.setH_From_Date_Month(rs.getInt("h_From_Date_Month"));
						h.setH_From_Date_Year(rs.getInt("h_From_Date_Year"));
						h.setH_To_Date_Day(rs.getInt("h_To_Date_Day"));
						h.setH_To_Date_Month(rs.getInt("h_To_Date_Month"));
						h.setH_To_Date_Year(rs.getInt("h_To_Date_Year"));
						h.setHoliday(rs.getString("Holiday"));
						hlist.add(h);
					}
					
					return hlist;
				}
			});
			return list;
	}

	@Override
	public String putDataDao(HolidayInfo h) {
		String result="Data inserted Successfully.";
		String sql="insert into employee.employee_holiday_information(Employee_ID_Number,h_From_Date_Day,h_From_Date_Month,h_From_Date_Year,h_To_Date_Day,"
				+ "h_To_Date_Month,h_To_Date_Year,Holiday) values("+h.getEmployee_ID_Number()+","+h.getH_From_Date_Day()+","+h.getH_From_Date_Month()+
				","+h.getH_From_Date_Year()+","+h.getH_To_Date_Day()+","+h.getH_To_Date_Month()+","+h.getH_To_Date_Year()+",'"+h.getHoliday()+"')";
		try {
		temp.execute(sql);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			result="Data insertion failed";
		}
		return result;
	}

	@Override
	public String removeDataById(int id) {
		String result="Holiday Information with ID Number "+id+" has been deleted Successfully.";
		String sql= "delete from employee.employee_holiday_information where Employee_ID_Number="+id;
		try {
	    temp.execute(sql);
		}
		catch(Exception e) {
			result="Data deletion failed.";
		}
		return result;
	}

	@Override
	public List<HolidayInfo> sortByNameDao(){
		List<HolidayInfo> list = temp.query("select * from employee.employee_holiday_information order by Holiday", new ResultSetExtractor<List<HolidayInfo>>() {
			
			List<HolidayInfo> hlist=new ArrayList<>();

			@Override
			public List<HolidayInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while(rs.next()) {
					HolidayInfo h = new HolidayInfo();
					h.setEmployee_ID_Number(rs.getInt("Employee_ID_Number"));
					h.setH_From_Date_Day(rs.getInt("h_From_Date_Day"));
					h.setH_From_Date_Month(rs.getInt("h_From_Date_Month"));
					h.setH_From_Date_Year(rs.getInt("h_From_Date_Year"));
					h.setH_To_Date_Day(rs.getInt("h_To_Date_Day"));
					h.setH_To_Date_Month(rs.getInt("h_To_Date_Month"));
					h.setH_To_Date_Year(rs.getInt("h_To_Date_Year"));
					h.setHoliday(rs.getString("Holiday"));
					hlist.add(h);
				}	
				return hlist;
			}
		});
		return list;
	}
	
	@Override
	public String updateHolidayInfoDao(HolidayInfo h) {
		String result="Data updated Successfully.";
		String sql="update employee.employee_holiday_information set h_From_Date_Day=?,h_From_Date_Month=?,h_From_Date_Year=?,h_To_Date_Day=?,"
				+ "h_To_Date_Month=?,h_To_Date_Year=?,Holiday=? where Employee_ID_Number=?";
		int records=0;
		try {
		records=temp.update(sql,h.getH_From_Date_Day(),h.getH_From_Date_Month(),h.getH_From_Date_Year(),h.getH_To_Date_Day(),h.getH_To_Date_Month()
				,h.getH_To_Date_Year(),h.getHoliday(),h.getEmployee_ID_Number());
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			result="Data insertion failed. Check Id Number";
		}
		return result+records+" records has changed.";
	}
}
