package com.emp.system.service;

import com.emp.system.dao.LoginDao;
import com.emp.system.dto.AdminDTO;
import com.emp.system.dto.EmployeeDTO;

public class LoginService {

	public LoginService() {
		// TODO Auto-generated constructor stub
	}

	public static EmployeeDTO validateEmployee(String empName, String password) {
	
	return LoginDao.validateEmployee(empName, password);
		
		
	}

	public static AdminDTO validateAdmin(String adminName, String adminPass) {
		
		return LoginDao.validateAdmin(adminName, adminPass);
	}

}
