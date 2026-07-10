package com.listenerdemo;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextAttributeListenerDemo
 *
 */
@WebListener
public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletContextAttributeListenerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	 System.out.println("ServletContext attribute added::{"
    	            + scae.getName() + ","
    	            + scae.getValue()
    	            + "}");
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	 System.out.println("ServletContext attribute removed::{"
 	            + scae.getName() + ","
 	            + scae.getValue()
 	            + "}");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	 System.out.println("ServletContext attribute replaced::{"
  	            + scae.getName() + ","
  	            + scae.getValue()
  	            + "}");
    }
	
}
