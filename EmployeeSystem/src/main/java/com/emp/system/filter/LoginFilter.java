package com.emp.system.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, description = "LoginFilter",  urlPatterns = {"/employeeLogin","/adminLogin"})
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		   System.out.println("-----------Login Filter called -------------");
		    HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) res;
		    
		    
		    //url for employee login  =http://localhost:8080/EmployeeSystem/employeeLogin
	         //url for admin login =http://localhost:8080/EmployeeSystem/adminLogin
	        
           String subPath = request.getPathInfo(); // Returns "/employeeLogin"
           String servletPath = request.getServletPath(); // Returns "null"

			 System.out.println("servletPath "+servletPath);
			 System.out.println("subPath "+subPath);
			 
		        if ("/employeeLogin".equals(servletPath)) {
		        	System.out.println("-----------Employee Filter -------------");
		        	employeeLoginFilter(request, response ,chain);
		     	   
		        } else if ("/adminLogin".equals(servletPath)) {
		        	System.out.println("-----------Admin Filter -------------");
		        	adminLoginFilter(request, response ,chain);
		        
		        }else {
		        	 String errorMessage = "Login failed. Please try again.";
		        	 request.setAttribute("errorMessage", errorMessage);
			         request.setAttribute("errorCode", "11-Return From LoginFilter");
					 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					 dispatcher.forward(request, response);
		        }
 
	}

	private void adminLoginFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)throws IOException, ServletException {
		 String adminName=request.getParameter("adminName");
		    String adminPass=request.getParameter("adminPass");
		    
		    if ((4<=adminName.length() && adminName.length() <=16)
		    		&& (4<=adminPass.length() && adminPass.length() <=16)){
		    	System.out.println("-----------Admin Login Filter 3333-------------");
		        // Allow the request to go to the next filter or target servlet
		        chain.doFilter(request, response);
		    } else {
		    	System.out.println("-----------Admin Login Filter 4444-------------");
		         String errorMessage = "Login failed. Please try again.";
		         request.setAttribute("errorMessage", errorMessage);
		         request.setAttribute("errorCode", "12-Return From LoginFilter");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response);
		    }
		
	}

	private void employeeLoginFilter(HttpServletRequest request, HttpServletResponse response ,FilterChain chain) throws IOException, ServletException {
		    String empName=request.getParameter("empName");
		    String password=request.getParameter("password");
		    
		    if ((4<=empName.length() && empName.length() <=16)
		    		&& (4<=password.length() && password.length() <=16)){
		    	System.out.println("-----------Employee Login  Filter 1111-------------");
		        // Allow the request to go to the next filter or target servlet
		        chain.doFilter(request, response);
		    } else {
		    	System.out.println("----------Employee Login Filter 2222-------------");
		         String errorMessage = "Login failed. Please try again.";
		         request.setAttribute("errorMessage", errorMessage);
		         request.setAttribute("errorCode", "13-Return From LoginFilter");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response);
		    }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
