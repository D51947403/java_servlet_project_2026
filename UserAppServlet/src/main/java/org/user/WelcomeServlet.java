package org.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String userName=request.getParameter("userName");  
		    out.print("Welcome "+userName);  
		    
		    ServletConfig config=getServletConfig();  
		    Enumeration<String> e=config.getInitParameterNames();  
		          
		    String str="";  
		    while(e.hasMoreElements()){  
		    str=e.nextElement();  
		    out.print("<br>Name: "+str);  
		    out.print(" value: "+config.getInitParameter(str));  
		    }  
		    
		    out.print("<br><br>"); 
		    out.print("======================================="); 
		    // Servlet Context Scope --Global
		    
		    ServletContext context=getServletContext();  
		    Enumeration<String> contextEnum=context.getInitParameterNames();  
		          
		    String conetxtparam="";  
		    while(contextEnum.hasMoreElements()){  
		    	conetxtparam=contextEnum.nextElement();  
		    	out.print("<br>Name: "+conetxtparam);  
		        out.print("<br>value: "+context.getInitParameter(conetxtparam));  
		    }  
		    
		    out.close();  
	}



}
