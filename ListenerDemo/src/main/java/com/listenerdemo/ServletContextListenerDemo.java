package com.listenerdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListenerDemo
 *
 */
public class ServletContextListenerDemo implements ServletContextListener {

    /**
     * Default constructor. 
     */
	 ServletContext ctx;
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
    	this.pageCount=10;
        ctx.setAttribute("pageCount",this.pageCount);
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// This should be called when web server tomcat will be stopped 
    	System.out.println("Web application destroyed and Servlet Context event occurred");
    	System.out.println("So Servlet Context listener is called");
    }

	
	
}
