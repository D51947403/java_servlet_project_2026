package com.emp.system.service;

import java.util.List;

import com.emp.system.dao.EmployeeDao;
import com.emp.system.dto.EmployeeDTO;

public class EmployeeService {

	public EmployeeService() {
	
	}

	public static int addEmployee(EmployeeDTO empObj) {
		// Business Logic to change name in upper case
		String empName = empObj.getEmpName().toUpperCase();
		
		empObj.setEmpName(empName);
		
		return  EmployeeDao.addEmployee(empObj);
	}

	public static List<EmployeeDTO> getEmployyeList() {
		return EmployeeDao.getEmployyeList();
	}

	public static EmployeeDTO getEmployeeById(int id) {
		return EmployeeDao.getEmployeeById(id);
	}

	public static void deleteEmployee(int empId) {
		EmployeeDao.deleteEmployee(empId);
	}

	public static int updateEmployee(EmployeeDTO empObj) {
		// Business Logic to change name in upper case
				String empName = empObj.getEmpName().toUpperCase();
				empObj.setEmpName(empName);
		return EmployeeDao.updateEmployee(empObj);
	}

	public static List<EmployeeDTO> getEmployeeByName(String viewEmpName) {
		// TODO Auto-generated method stub
		return EmployeeDao.getEmployeeByName(viewEmpName);
	}
}
