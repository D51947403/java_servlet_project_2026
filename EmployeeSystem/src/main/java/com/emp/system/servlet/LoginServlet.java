package com.emp.system.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.system.dto.AdminDTO;
import com.emp.system.dto.EmployeeDTO;
import com.emp.system.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "LoginServlet", urlPatterns = {"/employeeLogin","/adminLogin","/guestLogin"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------Login Servlet called -------------");
		
		         //url for employee login  =http://localhost:8080/EmployeeSystem/employeeLogin
		         //url for admin login =http://localhost:8080/EmployeeSystem/adminLogin
		        
               // String subPath = request.getPathInfo(); //  Returns "null" 
                String servletPath = request.getServletPath(); //Returns "/employeeLogin"

				 System.out.println("servletPath "+servletPath);
				 //System.out.println("subPath "+subPath);
				 
			        if ("/employeeLogin".equals(servletPath)) {
			        	System.out.println("-----------Employee Login -------------");
			        	employeeLogin(request, response);
			     	   
			        } else if ("/adminLogin".equals(servletPath)) {
			        	System.out.println("-----------Admin Login -------------");
			        	adminLogin(request ,response );
			        
			        }else {
				        String errorMessage ="Unauthorised Login request!";
				        // Authentication failed: Redirect back to login with error trigger
						request.setAttribute("errorMessage", errorMessage);
						request.setAttribute("errorCode", "24-Return From LoginServlet");
						RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
						dispatcher.forward(request, response);
			        }
		
		
	}

	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Fetch input parameters from the request form
		String adminName = request.getParameter("adminName");
		String adminPass = request.getParameter("adminPass");

		AdminDTO adminObj=LoginService.validateAdmin(adminName, adminPass);
		
		HttpSession session=null;
		
		if(adminObj != null) {
			session =request.getSession(true); // LoginListener will be called here
		    // Authentication successful: Save user info in the session scope
		    session.setAttribute("adminName", adminObj.getAdminName());
		    session.setAttribute("adminObj", adminObj);
		    session.setAttribute("loginSuccess", "Admin Login Successful.");
		    response.sendRedirect("home.jsp");
		} else {
			String errorMessage ="Admin name or password error!";
		    // Authentication failed: Redirect back to login with error trigger
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("errorCode", "22-Return From LoginServlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Fetch input parameters from the request form
		String empName = request.getParameter("empName");
		String password = request.getParameter("password");

		EmployeeDTO empObj=LoginService.validateEmployee(empName, password);
		
		HttpSession session=null;
		
		if(empObj != null) {
			session =request.getSession(true); // LoginListener will be called here
		    // Authentication successful: Save user info in the session scope
		    session.setAttribute("empName", empObj.getEmpName());
		    session.setAttribute("empObj", empObj);
		    session.setAttribute("loginSuccess", "Emplyee Login Successful.");
		    response.sendRedirect("home.jsp");
		} else {
			String errorMessage ="Employee name or password error!";
		    // Authentication failed: Redirect back to login with error trigger
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("errorCode", "23-Return From LoginServlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}


}
