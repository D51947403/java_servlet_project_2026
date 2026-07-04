package org.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBServlet
 */
//@WebServlet(description = "DBServlet", urlPatterns = { "/DBServlet" })
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		      
		    // Servlet Config Object  Scope ---Within servlet
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
