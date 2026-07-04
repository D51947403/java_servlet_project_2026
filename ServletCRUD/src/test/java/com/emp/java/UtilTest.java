package com.emp.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.emp.crud.Util;

public class UtilTest {
	
public static void main(String args[]) {
	
	Connection con =Util.getConnection();
	
	System.out.println("Connection established \n "+con);
	
	try {
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from employee");  
	while(rs.next())  {
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+"  "+rs.getString(5));  
	
	
	}
	con.close();  
	   }catch(Exception e){ System.out.println(e);}  
	}  

	
}


