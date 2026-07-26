package com.emp.system.listner;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.emp.system.util.EmailUtil;
import com.emp.system.util.SMSUtil;

/**
 * Application Lifecycle Listener implementation class LoginHttpSessionListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionListener {
    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("==========LoginListener called ==========");
    	EmailUtil.sendEmailOtp();
    	SMSUtil.sendSmsOtp();
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("==========Session closed  ==========");
    	
    }
	
}
