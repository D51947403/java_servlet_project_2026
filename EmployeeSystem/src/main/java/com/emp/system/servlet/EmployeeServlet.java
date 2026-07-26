package com.emp.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emp.system.dto.EmployeeDTO;
import com.emp.system.service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(description = "EmployeeServlet", urlPatterns = { "/employee/*" ,"/saveEmployee","/updateEmployee",
		"/editEmployee" ,"/deleteEmployee" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Calling GET Method ");
		 response.setContentType("text/html");  
	      PrintWriter out=response.getWriter();  
		// Contains the sub-path
		 String pathInfo = request.getPathInfo(); 
	        
	        if ("/viewById".equals(pathInfo)) {
	            // Handle profile GET
	        	 viewEmployeeById(request, out);
	     	   
	        } else if ("/viewByName".equals(pathInfo)) {
	            // Handle settings GET
	        	viewEmployeeByName(request, out);
	        }else {
		
	            listAllEmployee(out);  
	        }
	        out.close();
	}

	/**
	 * @param request
	 * @param out
	 */
	private void viewEmployeeById(HttpServletRequest request, PrintWriter out) {
		out.println("<h1>Employees BY ID</h1>"); 
		 String viewEmpId = request.getParameter("viewEmpId");
		int empId = 0; 
		if(viewEmpId != null) {
			empId= Integer.parseInt(viewEmpId); 
		}
		 
   	   EmployeeDTO emp=EmployeeService.getEmployeeById(empId);
   	   
   	   if (emp==null) {
		  out.print("No record found for employee Id: "+empId); 
   	   }{ 
		out.print("<table border='1'>");  
		out.print("<tr><td>Employee ID: </td><td>"+emp.getEmpId()+"</td></tr>");  
		out.print("<tr><td>Name:</td><td>"+emp.getEmpName()+"</td></tr>");  
		out.print("<tr><td>Email:</td><td>"+emp.getMailId()+"</td></tr>");  
		out.print("<tr><td>Country:</td><td>"+emp.getCountry()+"<td></tr>");   
		out.print("</table>");  
   	   }
	}

	/**
	 * @param request
	 * @param out
	 */
	private void viewEmployeeByName(HttpServletRequest request, PrintWriter out) {
		 out.println("<h1>Employees BY Name</h1>");  
		 String viewEmpName = request.getParameter("viewEmpName");
		 List<EmployeeDTO> empList=null;
		if(viewEmpName != null) {
			 empList=EmployeeService.getEmployeeByName(viewEmpName);
		}

   	   if (empList==null) {
		  out.print("No record found for employee name: "+viewEmpName); 
   	   }{ 
   		  out.print("<table border='1' width='80%'");  
	      out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th></tr>");  
	        for(EmployeeDTO e:empList){  
	       out.print("<tr>"
	       		+ "<td>"+e.getEmpId()+"</td><td>"+e.getEmpName()+"</td>"+  
	              "<td>"+e.getMailId()+"</td><td>"+e.getCountry()+"</td>"
	              + "</tr>");  
	      }  
	      out.print("</table>");  
   	   }
	}
	/**
	 * @param out
	 */
	private void listAllEmployee(PrintWriter out) {
		  out.println("<a href='index.html'>Add New Employee</a>");  
		  out.println("<br/>");
	      out.println("<h1>Employees List</h1>");  
	        
	      List<EmployeeDTO> list=EmployeeService.getEmployyeList();
	        
	      out.print("<table border='1' width='100%'");  
	      out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th> "+ 
	              " <th>Edit</th><th>Delete</th></tr>");  
	        for(EmployeeDTO e:list){  
	       out.print("<tr>"
	       		+ "<td>"+e.getEmpId()+"</td><td>"+e.getEmpName()+"</td>"+  
	              "<td>"+e.getMailId()+"</td><td>"+e.getCountry()+"</td>"+
	              // Form uses POST because HTML doesn't natively support PUT
	              "<td><form action='editEmployee' method='post'> "
	              // Hidden input to flag this as a PUT operation
	              +"<input type='hidden' name='_method' value='PUT'>"
	              + "     <input type='hidden' name='editEmpId' value='"+e.getEmpId()+"'/> "
	              + "    <button type='submit'>Edit</button> \r\n"
	              + "</form></td>"+
	              // Form uses POST because HTML doesn't natively support DELETE
					"<td><form action='deleteEmployee' method='post'> "
					  // Hidden input to flag this as a PUT operation
		              +"<input type='hidden' name='_method' value='DELETE'>"
					+ "     <input type='hidden' name='deleteEmpId' value='"+e.getEmpId()+"'/> "
					+ "    <button type='submit'>Delete</button> \r\n"
					+ "</form></td>"
					+ "</tr>");  
	      }  
	      out.print("</table>");  
	        
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodOverride = request.getParameter("_method");
		
		String editEmpId = request.getParameter("editEmpId");
		int updateEmpId = 0; 
		if(editEmpId != null) {
			updateEmpId= Integer.parseInt(editEmpId); 
		}
	    
	    if ("PUT".equalsIgnoreCase(methodOverride)) {
	        // Manually forward the request and response to doPut
	    	 LOGGER.info("PUT Method");
	        doPut(request, response);
	    } else if ("DELETE".equalsIgnoreCase(methodOverride)){
	    	 // Manually forward the request and response to doPut
	    	LOGGER.info("DELETE Method");
	    	doDelete(request, response);
	    }else if(updateEmpId >0){
	    	// Update record by post method
	    	LOGGER.info("POST Method for update");
	    	    updateEmployeeRecord(request, response);  
	    }else{
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
		response.setContentType("text/html");
			
		   // using through filter
			String empName=(String) request.getAttribute("empNameFromFilter");
			
			// Using directly from form
			String mailId=request.getParameter("mailId");
			String password=request.getParameter("password");
			String country=request.getParameter("country");
			
			EmployeeDTO  emp = new EmployeeDTO();
			 emp.setEmpName(empName);
			 emp.setMailId(mailId);
			 emp.setPassword(password);
			 emp.setCountry(country);
			 
			 int status =EmployeeService.addEmployee(emp);
			 System.out.println("status: " +status);
				LOGGER.info("status  "+status);
			PrintWriter out = response.getWriter();
			if(status >0) {
				out.print("<p colour='#76D7C4'>Record inserted successfully.<p>");
				RequestDispatcher rd= request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}else {
				out.print("<p colour='#F1948A'>Sorry! unable to save record.<p>");
			}
			
			out.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void updateEmployeeRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		  
		String editEmpId=request.getParameter("editEmpId");  
		int empId=Integer.parseInt(editEmpId);  
		
		// using through filter
		String empName=(String) request.getAttribute("empNameFromFilter"); 
		
		// empName direct from Form  
		String ename=request.getParameter("empName");  
		LOGGER.info("Employee Name from form"+ ename); 
		
		String password=request.getParameter("password");  
		String mailId=request.getParameter("mailId");  
		String country=request.getParameter("country");  
		  
		EmployeeDTO emp=new EmployeeDTO();  
		emp.setEmpId(empId);  
		emp.setEmpName(empName);  
		emp.setPassword(password);  
		emp.setMailId(mailId);  
		emp.setCountry(country);  
		 
		int status=EmployeeService.updateEmployee(emp) ; 
		
		if(status>0){  
		    response.sendRedirect("employee");  
		}else{  
		    out.println("Sorry! unable to update record");  
		}  
		  
		out.close();
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("PUT Method ");
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
	    
	        String empId=request.getParameter("editEmpId");  
	        
	        int id=Integer.parseInt(empId);  
	          
	        EmployeeDTO emp=EmployeeService.getEmployeeById(id);
	          
	        out.print("<form action='updateEmployee' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='editEmpId' value='"+emp.getEmpId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='empName' value='"+emp.getEmpName()+"'/></td></tr>");  
	        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+emp.getPassword()+
	        		"'/></td></tr>");  
	        out.print("<tr><td>Email:</td><td><input type='email' name='mailId' value='"+emp.getMailId()+"'/></td></tr>");  
	        out.print("<tr><td>Country:</td><td>");  
	        out.print("<select name='country' style='width:150px'>");  
	        out.print("<option>India</option>");  
	        out.print("<option>USA</option>");  
	        out.print("<option>UK</option>");  
	        out.print("<option>Other</option>");  
	        out.print("</select>");  
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();    
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("DELETE Method ");
		String deleteEmpId=request.getParameter("deleteEmpId");  
        int empId=Integer.parseInt(deleteEmpId);  
        EmployeeService.deleteEmployee(empId);
        response.sendRedirect("employee");  
	}

}
