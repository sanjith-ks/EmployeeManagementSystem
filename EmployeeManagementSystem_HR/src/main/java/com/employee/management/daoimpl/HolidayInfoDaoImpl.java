package com.employee.management.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.employee.management.dao.HolidayInfoDao;
import com.employee.management.models.HolidayInfo;

public class HolidayInfoDaoImpl implements HolidayInfoDao{

	@Autowired
	JdbcTemplate db;

	@Override
	public List<HolidayInfo> getallHolidayInfo() {

		List<HolidayInfo> holidaylist = db.query("select * from employee.employee_holiday_information", new ResultSetExtractor<List<HolidayInfo>>() {

			List<HolidayInfo> daylist = new ArrayList<>();

			@Override
			public List<HolidayInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					HolidayInfo s = new HolidayInfo();
					s.setEmployee_ID_Number(rs.getInt("Employee_ID_Number"));
					s.setHoliday(rs.getString("Holiday"));
					s.setH_From_Date_Day(rs.getInt("h_From_Date_Day"));
					s.setH_From_Date_Month(rs.getInt("h_From_Date_Month"));
					s.setH_From_Date_Year(rs.getInt("h_From_Date_Year"));
					s.setH_To_Date_Day(rs.getInt("h_To_Date_Day"));
					s.setH_To_Date_Month(rs.getInt("h_To_Date_Month"));
					s.setH_To_Date_Year(rs.getInt("h_To_Date_Year"));
					daylist.add(s);
				}

				return daylist;
			}
		});

		return holidaylist;
	}
}
