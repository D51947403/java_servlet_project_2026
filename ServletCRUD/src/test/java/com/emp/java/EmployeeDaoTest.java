package com.emp.java;

import com.emp.crud.EmployeeDTO;
import com.emp.crud.EmployeeDao;

public class EmployeeDaoTest {

	public static void main(String args[]) {
		EmployeeDao empDao= new EmployeeDao();
		// emp object
		EmployeeDTO empObj = new EmployeeDTO();
		empObj.setEmpId(2);
		empObj.setEmpName("Harish Singraul");
		empObj.setMailId("Harish24689@gmail.com");
		empObj.setPassword("Fire@123");
		empObj.setCountry("India");
		int status = EmployeeDao.addEmployee(empObj);
		 //int status =updateEmployee( empObj);
		// int status = deleteEmployee(1);
		// System.out.println("status " + status);	
		//System.out.println("employee " + getEmployeeById(1));
		System.out.println("employee list \n " + EmployeeDao.getEmployyeList());
	}

}
