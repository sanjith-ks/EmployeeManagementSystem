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

import com.employee.management.dao.EmployeeBasicDao;
import com.employee.management.models.BasicDetails;

@Component
public class EmployeeBasicDaoImpl implements EmployeeBasicDao {

	@Autowired
	JdbcTemplate db;

	@Override
	public List<BasicDetails> getAllDataDao() {

		List<BasicDetails> employeelist = db.query("select * from employee.employee_basic_details", new ResultSetExtractor<List<BasicDetails>>() {

			List<BasicDetails> elist=new ArrayList<>();

			@Override
			public List<BasicDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					BasicDetails e= new BasicDetails();
					e.setAddress(rs.getString("Address"));
					e.setCellularPhone(rs.getLong("Cellular_Phone"));
					e.setCity(rs.getString("City"));
					e.setCurrentExperience(rs.getString("Current_Experience"));
					e.setDayOfBirth(rs.getInt("Day_Of_Birth"));
					e.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					e.setEndDateDay(rs.getInt("End_Date_Day"));
					e.setEndDateMonth(rs.getInt("End_Date_Month"));
					e.setEndDateYear(rs.getInt("End_Date_Year"));
					e.setFirstName(rs.getString("First_Name"));
					e.setGender(rs.getString("Gender"));
					e.setHomePhone(rs.getLong("Home_Phone"));
					e.setLastName(rs.getString("Last_Name"));
					e.setMaritalStatus(rs.getString("Marital_Status"));
					e.setMiddleName(rs.getString("Middle_Name"));
					e.setMonthOfBirth(rs.getInt("Month_Of_Birth"));
					e.setPersonalIDNumber(rs.getInt("Personal_ID_Number"));
					e.setPostalCode(rs.getInt("Postal_Code"));
					e.setQualification(rs.getString("Qualification"));
					e.setStartDateDay(rs.getInt("Start_Date_Day"));
					e.setStartDateMonth(rs.getInt("Start_Date_Month"));
					e.setStartDateYear(rs.getInt("Start_Date_Year"));
					e.setTypeOfEmployee(rs.getString("Type_Of_Employee"));
					e.setYearOfBirth(rs.getInt("Year_Of_Birth"));
					
					elist.add(e);
				}

				return elist;
			}
		});

		return employeelist;
	}

	@Override
	public String putDataDao(BasicDetails b) {
		
		String result="Data Inserted Successfully for ID Number "+b.getEmployeeIDNumber();
		
		String sql="insert into employee.employee_basic_details(Employee_ID_Number,Personal_ID_Number,First_Name,Middle_Name,Last_Name, Day_Of_Birth,Month_Of_Birth "
				+ ",Year_Of_Birth,Cellular_Phone,Home_Phone,City,Address,Postal_Code,Qualification,Current_Experience,Start_Date_Day,Start_Date_Month,Start_Date_Year, "
				+ "End_Date_Day,End_Date_Month,End_Date_Year,Type_Of_Employee,Gender,Marital_Status) values("+b.getEmployeeIDNumber()+","+b.getPersonalIDNumber()+",'"+b.getFirstName()
				+"','"+b.getMiddleName()+"','"+b.getLastName()+"',"+b.getDayOfBirth()+","+b.getMonthOfBirth()+","+b.getYearOfBirth()+","+b.getCellularPhone()+","+b.getHomePhone()
				+",'"+b.getCity()+"','"+b.getAddress()+"',"+b.getPostalCode()+",'"+b.getQualification()+"','"+b.getCurrentExperience()+"',"+b.getStartDateDay()+","
				+b.getStartDateMonth()+","+b.getStartDateYear()+","+b.getEndDateDay()+","+b.getEndDateMonth()+","+b.getEndDateYear()+",'"+b.getTypeOfEmployee()+"','"
				+b.getGender()+"','"+b.getMaritalStatus()+"')";
		
		try {
			db.execute(sql);
		}
		catch(Exception e) {
			result="Data insertion failed.";
		}
		
		return result;
	}

	@Override
	public String removeDataByIdDao(int id) {
		
		String result="BasicInfo with ID Number "+id+" has been deleted Successfully.";
		String sql= "delete from employee.employee_basic_details where Employee_ID_Number="+id;
		try {
		db.execute(sql);
		}
		catch(Exception e) {
			result="Data deletion failed.";
		}
		return result;
	}
	
	@Override
	public List<BasicDetails> sortByNameDao(){
		
		List<BasicDetails> employeelist = db.query("select * from employee.employee_basic_details order by First_Name,Last_Name", new ResultSetExtractor<List<BasicDetails>>() {

			List<BasicDetails> elist=new ArrayList<>();

			@Override
			public List<BasicDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					BasicDetails e= new BasicDetails();
					e.setAddress(rs.getString("Address"));
					e.setCellularPhone(rs.getLong("Cellular_Phone"));
					e.setCity(rs.getString("City"));
					e.setCurrentExperience(rs.getString("Current_Experience"));
					e.setDayOfBirth(rs.getInt("Day_Of_Birth"));
					e.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					e.setEndDateDay(rs.getInt("End_Date_Day"));
					e.setEndDateMonth(rs.getInt("End_Date_Month"));
					e.setEndDateYear(rs.getInt("End_Date_Year"));
					e.setFirstName(rs.getString("First_Name"));
					e.setGender(rs.getString("Gender"));
					e.setHomePhone(rs.getLong("Home_Phone"));
					e.setLastName(rs.getString("Last_Name"));
					e.setMaritalStatus(rs.getString("Marital_Status"));
					e.setMiddleName(rs.getString("Middle_Name"));
					e.setMonthOfBirth(rs.getInt("Month_Of_Birth"));
					e.setPersonalIDNumber(rs.getInt("Personal_ID_Number"));
					e.setPostalCode(rs.getInt("Postal_Code"));
					e.setQualification(rs.getString("Qualification"));
					e.setStartDateDay(rs.getInt("Start_Date_Day"));
					e.setStartDateMonth(rs.getInt("Start_Date_Month"));
					e.setStartDateYear(rs.getInt("Start_Date_Year"));
					e.setTypeOfEmployee(rs.getString("Type_Of_Employee"));
					e.setYearOfBirth(rs.getInt("Year_Of_Birth"));
					
					elist.add(e);
				}
				return elist;
			}
		});
		return employeelist;	
	}
	
	@Override
	public String updateBasicInfoDao(BasicDetails b) {

		String result="Data updated Successfully. ";
		String sql="update employee.employee_basic_details set Personal_ID_Number=?,First_Name=?,Middle_Name=?,Last_Name=?, Day_Of_Birth=?,Month_Of_Birth=?"
				+ ",Year_Of_Birth=?,Cellular_Phone=?,Home_Phone=?,City=?,Address=?,Postal_Code=?,Qualification=?,Current_Experience=?,Start_Date_Day=?,Start_Date_Month=?,Start_Date_Year=?,"
				+ "End_Date_Day=?,End_Date_Month=?,End_Date_Year=?,Type_Of_Employee=?,Gender=?,Marital_Status=? where Employee_ID_Number=? ";
		int records=0;
		try {
			records=db.update(sql, b.getPersonalIDNumber(),b.getFirstName(),b.getMiddleName(),b.getLastName(),b.getDayOfBirth(),b.getMonthOfBirth(),
					b.getYearOfBirth(),b.getCellularPhone(),b.getHomePhone(),b.getCity(),b.getAddress(),b.getPostalCode(),b.getQualification(),b.getCurrentExperience(),b.getStartDateDay(),b.getStartDateMonth(),
					b.getStartDateYear(),b.getEndDateDay(),b.getEndDateMonth(),b.getEndDateYear(),b.getTypeOfEmployee(),b.getGender(),b.getMaritalStatus(),b.getEmployeeIDNumber());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			result="Data update failed. Check Id Number >> ";
		}
		return result+records+" records has changed.";
	}

}
