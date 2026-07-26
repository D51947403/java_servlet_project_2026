package com.emp.crud;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
 /**
	 * 
	 */
private static final long serialVersionUID = 1L;

 private int empId ;
 private String empName;
 private String mailId;
 private String password;
 private String country;


public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId =empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

@Override
public String toString() {
	return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", mailId=" + mailId + ", password=" + password
			+ ", country=" + country + "]";
}


 
}
