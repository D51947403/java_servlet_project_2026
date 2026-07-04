package com.emp.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	
	public static int addEmployee(EmployeeDTO empObj) {
		int status = 0;

		try {
			Connection con = Util.getConnection();
			String inserSql="insert into employee (emp_name , mail_id , pswd , country) \r\n" + 
					"value(? , ?, ? , ?) ;";
			PreparedStatement  ps =con.prepareStatement(inserSql);
			
			ps.setString(1 , empObj.getEmpName());
			ps.setString(2 , empObj.getMailId());
			ps.setString(3 , empObj.getPassword());
			ps.setString(4 , empObj.getCountry());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;

	}

	public static int updateEmployee(EmployeeDTO empObj) {
		int status = 0;
		try {
			Connection con = Util.getConnection();
			String updateSql="update employee e set e.emp_name= ? ,e.mail_id=? ,  \r\n" + 
					"e.pswd=? , e.country=?  where emp_id= ? ;";
			PreparedStatement  ps =con.prepareStatement(updateSql);
			
			ps.setString(1 , empObj.getEmpName());
			ps.setString(2 , empObj.getMailId());
			ps.setString(3 , empObj.getPassword());
			ps.setString(4 , empObj.getCountry());
			ps.setInt(5 , empObj.getEmpId());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;

	}

	public static int deleteEmployee(int empId) {
		int status = 0;
		try {
			Connection con = Util.getConnection();
			String deleteSql="update employee e set e.is_deleted='Y' where emp_id= ? ;";
			PreparedStatement  ps =con.prepareStatement(deleteSql);
			ps.setInt(1 , empId);
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;

	}

	public static EmployeeDTO getEmployeeById(int empId) {

		EmployeeDTO empObj = new EmployeeDTO();
		try {
			Connection con = Util.getConnection();
			String selectSql="select emp_id , emp_name , mail_id , pswd , country  from employee where \r\n" + 
					" emp_id =? and is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setInt(1 , empId);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setMailId(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return empObj;

	}

	public static List<EmployeeDTO> getEmployyeList() {
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
		EmployeeDTO empObj = null;

		try {
			Connection con = Util.getConnection();
			String selectAllSql="select emp_id ,emp_name , mail_id ,pswd , country  from employee where is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new EmployeeDTO() ;
				
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setMailId(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
				
				empList.add(empObj);
			}
			
			con.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return empList;

	}

	public static List<EmployeeDTO> getEmployeeByName(String viewEmpName) {
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
		EmployeeDTO empObj = null;
		try {
			Connection con = Util.getConnection();
			String selectSql="select emp_id , emp_name , mail_id , pswd , country  from employee where emp_name like ? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , viewEmpName + "%");
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new EmployeeDTO() ;
				
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setMailId(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
				
				empList.add(empObj);
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return empList;

	}

	
}
