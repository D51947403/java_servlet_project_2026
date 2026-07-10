package com.listenerdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



/**
 * Application Lifecycle Listener implementation class ServletContextListenerDemo
 *
 */
public class ServletContextListenerDemo implements ServletContextListener {

	  // Class data members
    ServletContext ctx;
    Connection connection;
    Statement statement;
    PreparedStatement ps;
    ResultSet rs;
    int pageCount;

    public ServletContextListenerDemo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Web application initialised and Servlet Context event occurred");
    	System.out.println("So Servlet Context listener is called");
    	ctx = sce.getServletContext();

    	// getting application level parameter
        String url = ctx.getInitParameter("DBURL");
        String user = ctx.getInitParameter("DBUSER");
        String pass = ctx.getInitParameter("DBPWD");
        String driver = ctx.getInitParameter("DBDRIVER");
        
     // create database connection
        // from init parameters
        // and set it to context
        DatabaseManager dbManager= new DatabaseManager(url, user, pass,driver);
       
        System.out.println("Database connection initialized for Application.");
        
        try {
			connection =dbManager.getConnection();
			
			String currentDate=AppUtil.getCurrentDate();
			
			System.out.println("currentDate: "+currentDate);
					
			this.pageCount= getPageCountFromDB(currentDate);
        
    	ctx.setAttribute("DBManager", dbManager);
        ctx.setAttribute("contextCount",this.pageCount);
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	/**
	 * @param currentDate
	 * @throws SQLException
	 */
	private int getPageCountFromDB(String currentDate) throws SQLException {
		statement =  connection.createStatement();
		// Fetching pageviews value from table counter
        rs = statement.executeQuery("select pageview from counter where created_date ="+currentDate+";");
        int count=0;
        // Iterating using next() method 
        while (rs.next()) {
        	count = rs.getInt(1);
        }
        return count;
	}
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// This should be called when web server tomcat will be stopped 
    	
    	System.out.println("Web application destroyed and Servlet Context event occurred");
    	System.out.println("So Servlet Context listener is called");
    	
        try {

        	ctx = sce.getServletContext();
        	
            int countFromContext = (Integer)ctx.getAttribute("contextCount");
            System.out.println("countFromContext: "+countFromContext);
            
            String currentDate=AppUtil.getCurrentDate();
			
			System.out.println("currentDate: "+currentDate);
					
			int todayCount= getPageCountFromDB(currentDate);
			if(todayCount>0) {
				 ps = connection.prepareStatement("update counter set pageview = "+ countFromContext+ " where created_date ="+currentDate);
			}else {
            ps = connection.prepareStatement("INSERT INTO counter (pageview) VALUES ("+ countFromContext +");");
			}
            ps.executeUpdate();
            
            DatabaseManager dbManager = (DatabaseManager)ctx.getAttribute( "DBManager");
             dbManager.closeConnection();
             System.out.println( "Database connection closed for Application.");
        } 
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    	
	
}
