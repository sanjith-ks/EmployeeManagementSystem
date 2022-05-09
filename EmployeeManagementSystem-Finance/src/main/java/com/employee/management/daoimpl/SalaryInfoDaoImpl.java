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

import com.employee.management.dao.SalaryInfoDao;
import com.employee.management.models.SalaryInfo;

@Component
public class SalaryInfoDaoImpl implements SalaryInfoDao {
	
	@Autowired
	JdbcTemplate db;
		

		@Override
		public List<SalaryInfo> getAllDataDao() {
			
			List<SalaryInfo> salarylist = db.query("select * from employee.employee_salary_information", new ResultSetExtractor<List<SalaryInfo>>() {
				
				List<SalaryInfo> slist=new ArrayList<>();

				@Override
				public List<SalaryInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					while(rs.next()) {
						SalaryInfo s = new SalaryInfo();
						s.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
						s.setMonthlyMoneyCurrency(rs.getString("Monthly_Money_Currency"));
						s.setMonthlySalary(rs.getInt("Monthly_Salary"));
						s.setSalary_cycle(rs.getInt("salary_cycle"));
						s.setPaid_salary(rs.getInt("paid_salary"));
						s.setMonthlyTaxes(rs.getInt("monthly_Taxes"));
						s.setNet_salary(rs.getInt("net_salary"));
						s.setPayable_salary(rs.getInt("payable_salary"));
						s.setMonthlydeductions(rs.getInt("monthly_deductions"));
						slist.add(s);
					}
					
					return slist;
				}
			});
			
			return salarylist;
		}
		
		@Override
		public String putDataDao(SalaryInfo s) {
			String result="SalaryInfo with ID number "+s.getEmployeeIDNumber()+" inserted Successfully.";
			String sql="insert into employee.employee_salary_information(Employee_ID_Number,Monthly_Salary,"
					+ "salary_cycle,paid_salary"
					+ ") values("+s.getEmployeeIDNumber()+","+s.getMonthlySalary()+
					","+s.getSalary_cycle()+","+s.getPaid_salary()+")";
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
			String result="SalaryInfo with ID Number "+id+" has been deleted Successfully.";
			String sql= "delete from employee.employee_salary_information where Employee_ID_Number="+id;
			try {
			db.execute(sql);
			}
			catch(Exception e) {
				result="Data deletion failed.";
			}
			return result;
		}

}
