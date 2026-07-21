<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="com.emp.crud.EmployeeDTO" %>
<%@ page import="com.emp.crud.EmployeeService" %>
<%@ page import="java.io.PrintWriter" %>

<%!	 
// Instantiate the logger using the current generated Servlet class name
private  final Logger LOGGER  = Logger.getLogger(this.getClass().getName());
%>

<%-- 1. SERVER-SIDE DATA STORE (Simulated Database using Session) --%>
<%
    // Fetch or initialize our mock database in the user's session
    Map<String, String> items = (Map<String, String>) session.getAttribute("db_items");
    if (items == null) {
        items = new ConcurrentHashMap<String, String>();
        items.put("1", "Original Item One");
        items.put("2", "Original Item Two");
        session.setAttribute("db_items", items);
    }
%>

<%-- 2. SERVER-SIDE FILTER & CONTROLLER (Method Interception) --%>
<%
    // Read the actual HTTP request method
    String httpMethod = request.getMethod(); 
    
    // Check if the form is attempting to tunnel a PUT or DELETE method
    String tunneledMethod = request.getParameter("_method");
    if (tunneledMethod != null && (tunneledMethod.equalsIgnoreCase("PUT") || tunneledMethod.equalsIgnoreCase("DELETE"))) {
        httpMethod = tunneledMethod.toUpperCase();
    }

    // Route business logic manually based on the resolved HTTP Method
    String message = "";

    if (httpMethod.equals("POST")) {
        // CREATE Operation
    	 String editEmpId = request.getParameter("editEmpId");
 		int updateEmpId = 0; 
 		if(editEmpId != null) {
 			updateEmpId= Integer.parseInt(editEmpId); 
 		}
 		
 		if(updateEmpId >0){
 	    	// Update record by post method
 	    	LOGGER.info("POST Method for update");
 	    	    updateEmployeeRecord(request, response);  
 	    	    message = "Successfully executed [POST]: Update ";
 	    }else{
 	    	// Create record by post method
 	    	LOGGER.info("POST Method for Create");
 	           saveEmployeeRecord(request, response);
 	       message = "Successfully executed [POST]: Created   ";

 	    }
		
    } 
    else if (httpMethod.equals("PUT")) {
        // UPDATE Operation
    	LOGGER.info("PUT Method ");
	    
	        String empId=request.getParameter("editEmpId");  
	        
	        int id=Integer.parseInt(empId);  
	          
	        EmployeeDTO emp=EmployeeService.getEmployeeById(id);
	        
%>	        
         <h1>Edit Employee</h1> 
	     <form action='updateEmployee' method='post'> 
	       <table> 
	      <tr><td></td><td><input type='hidden' name='editEmpId' value='${emp.getEmpId()}'/></td></tr>  
	      <tr><td>Name:</td><td><input type='text' name='empName' value='${emp.getEmpName()}'/></td></tr>
	        <tr><td>Password:</td><td><input type='password' name='password' value='${emp.getPassword()}'/></td></tr> 
	        <tr><td>Email:</td><td><input type='email' name='mailId' value='${emp.getMailId()}'/></td></tr>
	        <tr><td>Country:</td><td>
	        <select name='country' style='width:150px'> 
	        <option>India</option>
	        <option>USA</option> 
	        <option>UK</option>  
	       <option>Other</option> 
	       </select>
	        </td></tr>
	       <tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr> 
	      </table> 
	      </form>
	          
  <%      
    } 
    else if (httpMethod.equals("DELETE")) {
        // DELETE Operation
      
    }else{
    	 // GET falls through naturally to render the UI below
    }
   
%>

<%!
     private void saveEmployeeRecord(HttpServletRequest request, HttpServletResponse response){
		
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
}


private void updateEmployeeRecord(HttpServletRequest request, HttpServletResponse response) {

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
	
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>JSP CRUD without JavaScript</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; line-height: 1.6; }
        .box { border: 1px solid #ccc; padding: 15px; margin-bottom: 20px; border-radius: 4px; }
        .alert { background: #e3f2fd; padding: 10px; color: #0d47a1; border-left: 5px solid #2196f3; }
        table { width: 50%; border-collapse: collapse; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        form { display: inline; }
    </style>
</head>
<body>
 <h2>JSP Pure HTML CRUD (GET, POST, PUT, DELETE)</h2>

    <%-- Display Status Message --%>
    <% if (!message.isEmpty()) { %>
        <div class="alert"><%= message %></div>
    <% } %>

    <%-- 1. READ (GET) --%>
    <div class="box">
        <h3>Current Data Store [GET]</h3>
        <table>
            <tr>
                <th>ID</th>
                <th>Value</th>
                <th>Actions</th>
            </tr>
            <% for (Map.Entry<String, String> entry : items.entrySet()) { %>
            <tr>
                <td><%= entry.getKey() %></td>
                <td><%= entry.getValue() %></td>
                <td>
                    <%-- 4. DELETE Form (Tunnels method via hidden param) --%>
                    <form action="crud.jsp" method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="hidden" name="id" value="<%= entry.getKey() %>">
                        <input type="submit" value="Delete" style="color:red;">
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
    </div>

    <%-- 2. CREATE (POST) --%>
    <div class="box">
       <h1>Add New Employee</h1>  
			<form action="saveEmployee" method="post">  
				<table>  
				<tr><td><input type='hidden' name='empId' value='-1'/></tr>
				<tr><td>Name:</td><td><input type="text" name="empName"/></td></tr>  
				<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>  
				<tr><td>Email:</td><td><input type="email" name="mailId"/></td></tr>  
				<tr><td>Country:</td><td>  
				<select name="country" style="width:150px">  
				<option>India</option>  
				<option>USA</option>  
				<option>UK</option>  
				<option>Other</option>  
				</select>  
				</td></tr>  
				<tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>  
				</table>  
			</form> 
    </div>







    <%-- 3. UPDATE (PUT) --%>
    <div class="box">
        <h3>Update Resource [PUT]</h3>
        <form action="crud.jsp" method="post">
            <%-- Method tunneling hidden field --%>
            <input type="hidden" name="_method" value="PUT">
            
            <label>ID to Update: <input type="text" name="id" required></label>
            <label>New Value: <input type="text" name="value" required></label>
            <input type="submit" value="Submit PUT (Update)">
        </form>
    </div>
</body>
</html>