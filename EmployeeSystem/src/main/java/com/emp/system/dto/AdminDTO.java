package com.emp.system.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable{

private static final long serialVersionUID = 1L;

 private int adminId ;
 private String adminName;
 private String mailId;
 private String adminPass;
 private String country;
 public int getAdminId() {
	return adminId;
 }
 public void setAdminId(int adminId) {
	this.adminId = adminId;
 }
 public String getAdminName() {
	return adminName;
 }
 public void setAdminName(String adminName) {
	this.adminName = adminName;
 }
 public String getMailId() {
	return mailId;
 }
 public void setMailId(String mailId) {
	this.mailId = mailId;
 }
 public String getAdminPass() {
	return adminPass;
 }
 public void setAdminPass(String adminPass) {
	this.adminPass = adminPass;
 }
 public String getCountry() {
	return country;
 }
 public void setCountry(String country) {
	this.country = country;
 }
 @Override
 public String toString() {
	return "AdminDTO [adminId=" + adminId + ", adminName=" + adminName + ", mailId=" + mailId + ",country=" + country + "]";
 }
   
 
  
}
