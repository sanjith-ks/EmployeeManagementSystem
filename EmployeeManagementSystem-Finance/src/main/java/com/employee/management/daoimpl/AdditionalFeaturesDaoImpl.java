package com.employee.management.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.employee.management.dao.AdditionalFeaturesDao;
import com.employee.management.models.BasicDetails;
import com.employee.management.models.SalaryInfo;
import com.employee.management.service.SalaryInfoService;

@Component
public class AdditionalFeaturesDaoImpl implements AdditionalFeaturesDao {

	Logger logger=LoggerFactory.getLogger(AdditionalFeaturesDaoImpl.class);
	
	@Autowired
	JdbcTemplate db;

	@Autowired
	SalaryInfoService salaryInfoService;

	@Override
	public String paySalaryDao(int sal,int id) {

		String result="Salary of Rs."+sal+" has been paid to the Employee with id number "+id;
		try {
			String sql="update employee.employee_salary_information set paid_salary=paid_salary+"+sal+" where Employee_ID_Number="+id;
			db.execute(sql);
		}catch(Exception e) {
			e.printStackTrace();
			result="Data insertion has been failed. Please check the Id number.";
			logger.error(result);
		}
		return result;
	}

	public String getSalaryWithNameDao() {

		String sql="select e1.Employee_ID_Number,First_Name,Last_Name,Monthly_Salary,net_salary,paid_salary,payable_salary from employee.employee_basic_details as e1\r\n"
				+ "inner join employee.employee_salary_information as e2 on e1.Employee_ID_Number=e2.Employee_ID_Number;";


		String em=db.query(sql, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String slist="";
				while(rs.next()) {
					BasicDetails s = new BasicDetails();
					s.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					s.setFirstName(rs.getString("First_Name"));
					s.setLastName(rs.getString("Last_Name"));
					String string="Employee Id Number = "+s.getEmployeeIDNumber()+"\nFirst Name = "+s.getFirstName()+"\nLast Name = "+s.getLastName();
					slist=slist+string;
				}
				return slist;
			}
		});

		String sal=db.query(sql, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String slist="";
				while(rs.next()) {
					SalaryInfo s = new SalaryInfo();
					s.setMonthlySalary(rs.getInt("Monthly_Salary"));
					s.setPaid_salary(rs.getInt("paid_salary"));
					s.setNet_salary(rs.getInt("net_salary"));
					s.setPayable_salary(rs.getInt("payable_salary"));
					String string="\nMonthly Salary = "+s.getMonthlySalary()+"\nNet Salary = "+s.getNet_salary()+"\nPaid Salary = "
							+s.getPaid_salary()+"\nPayable Salary = "+s.getPayable_salary();
					slist=slist+string;
				}
				return slist;
			}
		});
		return em+sal;
	}

	@Override
	@Scheduled(cron="0 0 0 * * *")
	public void clearPaidSalaryDao() {
		Calendar date =Calendar.getInstance();
		System.out.println("hi");
		int d=date.get(Calendar.DATE);
		List<SalaryInfo> list =salaryInfoService.getAllDataService();
		try {
			for(SalaryInfo s:list) {
				if(s.getSalary_cycle()==d) {
					if(s.getPayable_salary()==0) {
						db.execute("update employee.employee_salary_information set paid_salary=0 where Employee_ID_Number="+s.getEmployeeIDNumber());
						logger.debug("Scheduled Task for updating paid salary has been updated to Employee Id : {} as {}",s.getEmployeeIDNumber(),0);
					}else {
						db.execute("update employee.employee_salary_information set paid_salary=-"+s.getPayable_salary()+" where Employee_ID_Number="+s.getEmployeeIDNumber());
						logger.debug("Scheduled Task for updating paid salary has been updated to Employee Id : {} as {}",s.getEmployeeIDNumber(),s.getPayable_salary());

					}
				}
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public String updateSalaryDao(int sal,int id) {

		SalaryInfo salaryInfo=salaryInfoService.getDataByIdService(id);
		String result="Employee with ID Number "+salaryInfo.getEmployeeIDNumber()+" has been successfully updated Monthly Salary as "+sal;
		String sql="update employee.employee_salary_information set Monthly_Salary="+sal+" where Employee_ID_Number="+id;
		try {
			db.execute(sql);
		}catch(Exception e) {
			e.printStackTrace();
			result="Data insertion has been failed. Please check the Id number.";
		}
		return result;
	}

}
