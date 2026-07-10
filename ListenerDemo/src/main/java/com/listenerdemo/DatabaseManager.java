package com.listenerdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	 private String dbURL;
	    private String user;
	    private String password;
	    private String driver;
	    private Connection connection;

	    public DatabaseManager(String url, String user, String pass, String driver) {
	    	 this.dbURL = url;
		        this.user = user;
		        this.password = pass;
		        this.driver=driver;
		}

		public Connection getConnection() throws SQLException {
			 // Load and register the driver
	        try {
				Class.forName(this.driver);
				 // Establish connection
		        this.connection = DriverManager.getConnection(this.dbURL, this.user, this.password);
		        System.out.println("Connection Established successfully to: " + this.dbURL);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return this.connection; 
			
		}

	    public void closeConnection()
	    {
	    	 if (connection != null) {
	             try {
	                 connection.close();
	                 System.out.println("Connection Closed....");
	             } catch (SQLException e) {
	                 System.err.println("Error closing connection: " + e.getMessage());
	             }
	         }
	    }
	    

}
