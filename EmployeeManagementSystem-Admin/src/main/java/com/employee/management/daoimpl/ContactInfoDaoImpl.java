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

import com.employee.management.dao.ContactInfoDao;
import com.employee.management.models.ContactInfo;

@Component
public class ContactInfoDaoImpl implements ContactInfoDao {

	@Autowired
	JdbcTemplate db;

	@Override
	public List<ContactInfo> getAllDataDao() {

		List<ContactInfo> contactlist = db.query("select * from employee.employee_contact_information", new ResultSetExtractor<List<ContactInfo>>() {

			List<ContactInfo> clist=new ArrayList<>();

			@Override
			public List<ContactInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					ContactInfo c = new ContactInfo();
					c.setcAddress(rs.getString("c_Address"));
					c.setcCellularPhone(rs.getLong("c_Cellular_Phone"));
					c.setcCity(rs.getString("c_City"));
					c.setcFirstName(rs.getString("c_First_Name"));
					c.setcHomePhone(rs.getLong("c_Home_Phone"));
					c.setcLastName(rs.getString("c_Last_Name"));
					c.setcMiddleName(rs.getString("c_Middle_Name"));
					c.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					clist.add(c);
				}

				return clist;
			}
		});

		return contactlist;
	}

	@Override
	public String putDataDao(ContactInfo c) {
		String result="Data inserted Successfully.";
		String sql="insert into employee.employee_contact_information(Employee_ID_Number,c_First_Name,c_Middle_Name,"
				+ "c_Last_Name,c_Cellular_Phone,c_Home_Phone,c_City,c_Address) values("+ c.getEmployeeIDNumber()+",'"+
				c.getcFirstName()+"','"+c.getcMiddleName()+"','"+c.getcLastName()+"',"+c.getcCellularPhone()+","+c.getcHomePhone()
				+",'"+c.getcCity()+"','"+c.getcAddress()+"')";
		try {
			db.execute(sql);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			result="Data insertion failed";
		}
		return result;
	}

	@Override
	public String removeDataById(int id) {
		String result="ContactInfo with ID Number "+id+" has been deleted Successfully.";
		String sql= "delete from employee.employee_contact_information where Employee_ID_Number="+id;
		try {
			db.execute(sql);
		}
		catch(Exception e) {
			result="Data deletion failed.";
		}
		return result;
	}

	@Override
	public List<ContactInfo> sortByNameDao(){

		List<ContactInfo> contactlist = db.query("select * from employee.employee_contact_information order by c_First_Name", new ResultSetExtractor<List<ContactInfo>>() {

			List<ContactInfo> clist=new ArrayList<>();

			@Override
			public List<ContactInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					ContactInfo c = new ContactInfo();
					c.setcAddress(rs.getString("c_Address"));
					c.setcCellularPhone(rs.getLong("c_Cellular_Phone"));
					c.setcCity(rs.getString("c_City"));
					c.setcFirstName(rs.getString("c_First_Name"));
					c.setcHomePhone(rs.getLong("c_Home_Phone"));
					c.setcLastName(rs.getString("c_Last_Name"));
					c.setcMiddleName(rs.getString("c_Middle_Name"));
					c.setEmployeeIDNumber(rs.getInt("Employee_ID_Number"));
					clist.add(c);
				}

				return clist;
			}
		});

		return contactlist;

	}

	@Override
	public String updateContactInfoDao(ContactInfo c) {

		String result="Data updated Successfully. ";
		String sql="update employee.employee_contact_information set c_First_Name=?,c_Middle_Name=?,"
				+ "c_Last_Name=?,c_Cellular_Phone=?,c_Home_Phone=?,c_City=?,c_Address=? where Employee_ID_Number=? ";
		int records=0;
		try {
			records=db.update(sql, c.getcFirstName(),c.getcMiddleName(),c.getcLastName(),c.getcCellularPhone(),c.getcHomePhone()
					,c.getcCity(),c.getcAddress(),c.getEmployeeIDNumber());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			result="Data update failed. Check Id Number >> ";
		}
		return result+records+" records has changed.";
	}

}
