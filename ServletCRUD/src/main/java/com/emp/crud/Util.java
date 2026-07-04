package com.emp.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

	public static Connection getConnection() {
		Connection con = null;
		String url ="jdbc:mysql://localhost:3306";
		String dbSchema="servlet_crud";
		String userName="root";
		String password="root";
		try {

			// This is deprecated.
		//	Class.forName("com.mysql.jdbc.Driver");
			
			// MySQL version 8.0.17
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url+"/"+dbSchema, userName , password );
		//	System.out.println("Connection "+con);

		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return con;

	}

	
}


