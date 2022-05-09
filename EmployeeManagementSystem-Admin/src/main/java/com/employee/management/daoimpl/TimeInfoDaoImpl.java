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

import com.employee.management.dao.TimeInfoDao;
import com.employee.management.models.TimeInfo;

@Component
public class TimeInfoDaoImpl implements TimeInfoDao {

	@Autowired
	JdbcTemplate temp;

	@Override
	public List<TimeInfo> getAllDataDao() {

		List<TimeInfo> list = temp.query("select * from employee.employee_time_information", new ResultSetExtractor<List<TimeInfo>>() {

			List<TimeInfo> tlist=new ArrayList<>();

			@Override
			public List<TimeInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					TimeInfo t = new TimeInfo();
					t.setDays_Off(rs.getInt("Days_Off"));
					t.setEmployee_ID_Number(rs.getInt("Employee_ID_Number"));
					t.setExtra_Days(rs.getInt("Extra_Days"));
					t.setOff_Hours(rs.getInt("Off_Hours"));
					t.setOver_Time(rs.getInt("Over_Time"));
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
	public String putDataDao(TimeInfo t) {
		String result="Data inserted Successfully.";
		String sql="insert into employee.employee_time_information(Employee_ID_Number,Worked_Hours,Off_Hours,Days_Off,Over_Time,Extra_Days,"
				+ "w_From_Date_Day,w_From_Date_Month,w_From_Date_Year,w_To_Date_Day,w_To_Date_Month,w_To_Date_Year) values("+t.getEmployee_ID_Number()
				+","+t.getWorked_Hours()+","+t.getOff_Hours()+","+t.getDays_Off()+","+t.getOver_Time()+","+t.getExtra_Days()+","+t.getW_From_Date_Day()
				+","+t.getW_From_Date_Month()+","+t.getW_From_Date_Year()+","+t.getW_To_Date_Day()+","+t.getW_To_Date_Month()+","+t.getW_To_Date_Year()+")";
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
		String result="Time Information with ID Number "+id+" has been deleted Successfully.";
		String sql= "delete from employee.employee_time_information where Employee_ID_Number="+id;
		try {
			temp.execute(sql);
		}
		catch(Exception e) {
			result="Data deletion failed.";
		}
		return result;
	}

	@Override
	public List<TimeInfo> sortbyDaysOffDao(){
		List<TimeInfo> list = temp.query("select * from employee.employee_time_information order by Days_Off,Off_Hours", new ResultSetExtractor<List<TimeInfo>>() {

			List<TimeInfo> tlist=new ArrayList<>();

			@Override
			public List<TimeInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					TimeInfo t = new TimeInfo();
					t.setDays_Off(rs.getInt("Days_Off"));
					t.setEmployee_ID_Number(rs.getInt("Employee_ID_Number"));
					t.setExtra_Days(rs.getInt("Extra_Days"));
					t.setOff_Hours(rs.getInt("Off_Hours"));
					t.setOver_Time(rs.getInt("Over_Time"));
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
	public String updateTimeInfoDao(TimeInfo t) {
		String result="Data updated Successfully.";
		String sql="update employee.employee_time_information set Worked_Hours=?,Off_Hours=?,Days_Off=?,Over_Time=?,Extra_Days=?,"
				+ "w_From_Date_Day=?,w_From_Date_Month=?,w_From_Date_Year=?,w_To_Date_Day=?,w_To_Date_Month=?,w_To_Date_Year=?"
				+ " where Employee_ID_Number=?";
		int records=0;
		try {
			records=temp.update(sql,t.getWorked_Hours(),t.getOff_Hours(),t.getDays_Off(),t.getOver_Time(),t.getExtra_Days()
					,t.getW_From_Date_Day(),t.getW_From_Date_Month(),t.getW_From_Date_Year(),t.getW_To_Date_Day(),
					t.getW_To_Date_Month(),t.getW_To_Date_Year(),t.getEmployee_ID_Number());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			result="Data insertion failed. Check Id Number";
		}
		return result+records+" records has changed.";
	}

}
