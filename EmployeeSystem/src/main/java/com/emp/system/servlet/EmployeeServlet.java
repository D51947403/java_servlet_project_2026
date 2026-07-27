package com.emp.system.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.system.dto.EmployeeDTO;
import com.emp.system.service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(description = "EmployeeServlet", urlPatterns = { "/employee", "/createEmployee","/displayImage","/viewById", "/viewByName", "/saveEmployee",
		"/updateEmployee", "/editEmployee", "/deleteEmployee" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 1. Initialize the Logger using the current class name
	private static final Logger LOGGER = Logger.getLogger(EmployeeServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Calling GET Method ");

		// Contains the sub-path
		String pathInfo = request.getPathInfo(); // return "null"
		System.out.println("pathInfo : " + pathInfo);
		String servletPath = request.getServletPath(); // Returns "/viewByName" or "/viewById"
		System.out.println("servletPath : " + servletPath);

		if ("/viewById".equals(servletPath)) {
			// Handle profile GET
			viewEmployeeById(request, response);

		} else if ("/viewByName".equals(servletPath)) {
			// Handle settings GET
			viewEmployeeByName(request, response);
		}  else if ("/createEmployee".equals(servletPath)) {
			// Handle settings GET
			createEmployee(request, response);
		} else if ("/displayImage".equals(servletPath)) {
			// Handle settings GET
			displayImage(request, response);
		}else {
			getEmployeeList(request, response);
		}
		
		

	}

	private void displayImage(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 response.setContentType("image/jpeg");  
		    ServletOutputStream out;  
		    out = response.getOutputStream();  
		  
		    // 1. Define the relative path starting from the root of the classpath  
		    // file is inside src/main/resources under images folder 
	        String resourcePath = "images/devendra_image.jpeg";
		    InputStream fin =  Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
		      
		    BufferedInputStream bin = new BufferedInputStream(fin);  
		    
		    BufferedOutputStream bout = new BufferedOutputStream(out);  
		    int ch =0; ;  
		    while((ch=bin.read())!=-1)  
		    {  
		    bout.write(ch);  
		    }  
		      
		    bin.close();  
		    fin.close();  
		    bout.close();  
		    out.close();  
		
	}

	private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		session.setAttribute("createEmployee", "CREATE_EMPLOYEE");
		response.sendRedirect("employee.jsp");
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getEmployeeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		List<EmployeeDTO> list = EmployeeService.getEmployyeList();
		session.setAttribute("empList", list);
		response.sendRedirect("employee.jsp");
	}

	/**
	 * @param request
	 * @param out
	 * @throws IOException
	 */
	private void viewEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String viewEmpId = request.getParameter("viewEmpId");
		int empId = 0;
		if (viewEmpId != null) {
			empId = Integer.parseInt(viewEmpId);
		}

		EmployeeDTO empObjByID = EmployeeService.getEmployeeById(empId);

		session.setAttribute("empObjByID", empObjByID);
		response.sendRedirect("employee.jsp");

	}

	/**
	 * @param request
	 * @param out
	 */
	private void viewEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String viewEmpName = request.getParameter("viewEmpName");
		List<EmployeeDTO> empSearchList = null;
		if (viewEmpName != null) {
			empSearchList = EmployeeService.getEmployeeByName(viewEmpName);
		}
		session.setAttribute("empSearchList", empSearchList);
		response.sendRedirect("employee.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methodOverride = request.getParameter("_method");

		String editEmpId = request.getParameter("editEmpId");
		int updateEmpId = 0;
		if (editEmpId != null) {
			updateEmpId = Integer.parseInt(editEmpId);
		}

		if ("PUT".equalsIgnoreCase(methodOverride)) {
			// Manually forward the request and response to doPut
			LOGGER.info("PUT Method");
			doPut(request, response);
		} else if ("DELETE".equalsIgnoreCase(methodOverride)) {
			// Manually forward the request and response to doDelete
			LOGGER.info("DELETE Method");
			doDelete(request, response);
		} else if (updateEmpId > 0) {
			// Update record by post method
			LOGGER.info("POST Method for update");
			updateEmployeeRecord(request, response);
		} else {
			// Create record by post method
			LOGGER.info("POST Method for Create");
			saveEmployeeRecord(request, response);

		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void saveEmployeeRecord(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// using through filter
		String empName = (String) request.getAttribute("empNameFromFilter");

		// Using directly from form
		String mailId = request.getParameter("mailId");
		String password = request.getParameter("password");
		String country = request.getParameter("country");

		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmpName(empName);
		emp.setMailId(mailId);
		emp.setPassword(password);
		emp.setCountry(country);

		int status = EmployeeService.addEmployee(emp);
		System.out.println("status: " + status);
		LOGGER.info("status  " + status);
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String insertMessage = null;

		if (status > 0) {
			insertMessage = "<p colour='#76D7C4'>Record inserted successfully.<p>";
		} else {
			insertMessage = "<p colour='#F1948A'>Sorry! unable to save record.<p>";
		}

		session.setAttribute("insertMessage", insertMessage);
		response.sendRedirect("employee.jsp");

	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void updateEmployeeRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String editEmpId = request.getParameter("editEmpId");
		int empId = Integer.parseInt(editEmpId);

		// using through filter
		String empName = (String) request.getAttribute("empNameFromFilter");

		// empName direct from Form
		String ename = request.getParameter("empName");
		LOGGER.info("Employee Name from form" + ename);

		String password = request.getParameter("password");
		String mailId = request.getParameter("mailId");
		String country = request.getParameter("country");

		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setPassword(password);
		emp.setMailId(mailId);
		emp.setCountry(country);

		int status = EmployeeService.updateEmployee(emp);

		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String updateMessage = null;

		if (status > 0) {
			updateMessage = "<p colour='#76D7C4'>Record updated successfully.<p>";
		} else {
			updateMessage = "<p colour='#F1948A'>Sorry! unable to update record.<p>";
		}

		session.setAttribute("updateMessage", updateMessage);
		response.sendRedirect("employee.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("PUT Method ");
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session

		String empId = request.getParameter("editEmpId");

		int id = Integer.parseInt(empId);

		EmployeeDTO editEmpObj = EmployeeService.getEmployeeById(id);

		session.setAttribute("editEmpObj", editEmpObj);
		response.sendRedirect("employee.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("DELETE Method ");
		String deleteEmpId = request.getParameter("deleteEmpId");
		int empId = Integer.parseInt(deleteEmpId);
		EmployeeService.deleteEmployee(empId);
		
		removeAttributes( request);
		
		HttpSession session = request.getSession(); // use existing session
		String deleteMessage = "<p colour='#76D7C4'>Record deleted successfully.<p>";;
		session.setAttribute("deleteMessage", deleteMessage);
		response.sendRedirect("employee.jsp");
	}

	 private void removeAttributes(HttpServletRequest request) {
		 HttpSession session = request.getSession(false);

		 if (session != null) {
		     java.util.Enumeration<String> attributeNames = session.getAttributeNames();
		     while (attributeNames.hasMoreElements()) {
		         String attrName = attributeNames.nextElement();
		         session.removeAttribute(attrName);
		     }
		 }
	 }
}
