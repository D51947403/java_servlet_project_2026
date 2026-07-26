package com.emp.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.emp.system.dto.AdminDTO;
import com.emp.system.dto.EmployeeDTO;
import com.emp.system.util.DbConnectUtil;

public class LoginDao {

	public LoginDao() {
	}

	public static EmployeeDTO validateEmployee(String empName, String password) {

		EmployeeDTO empObj = null;
		try {
			Connection con = DbConnectUtil.getConnection();
			String selectSql="select emp_id , emp_name , mail_id , pswd , country  from employee where \r\n" + 
					" emp_name =? and pswd=? and is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , empName);
			ps.setString(2 , password);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new EmployeeDTO();
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setMailId(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
				break;
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return empObj;
	}

	public static AdminDTO validateAdmin(String adminName, String adminPass) {
		AdminDTO adminObj = null;
		try {
			Connection con = DbConnectUtil.getConnection();
			String selectSql="select admin_id , admin_name , mail_id , admin_pass , country  from admin_detail where \r\n" + 
					" admin_name =? and admin_pass=? and is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , adminName);
			ps.setString(2 , adminPass);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				adminObj = new AdminDTO();
				adminObj.setAdminId(rs.getInt(1));
				adminObj.setAdminName(rs.getString(2));
				adminObj.setMailId(rs.getString(3));
				adminObj.setAdminPass(rs.getString(4));
				adminObj.setCountry(rs.getString(5));
				break;
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return adminObj;
	}

}
