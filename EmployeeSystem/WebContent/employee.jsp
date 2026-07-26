<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="com.emp.system.dto.EmployeeDTO" %>
<%@ page import="com.emp.system.service.EmployeeService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<!-- Step 1: Inject the common header -->
<jsp:include page="header.jsp" />

    <h1>Welcome to Employee page</h1>
    
    
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
  
<br/>  <br/>  
<a href="employee">View All Employees</a>  

<%
List<EmployeeDTO> list= (List<EmployeeDTO>)request.getAttribute("empList");
%>
	        




        <br/> <br/>

		<form action="employee/viewById" method="get">
			<input type="number" name="viewEmpId"> 
			<input type="submit" value="View Employee By Id">
		</form>
		
		  <br/> <br/>

		<form action="employee/viewByName" method="get">
			<input type="text" name="viewEmpName"> 
			<input type="submit" value="View Employee By Name">
		</form>

  <br/>  <br/>  
<a href="/ServletCRUD/displayImage">View Photo</a>  
    
    
    
    
    
      
 <!-- Step 3: Inject the common footer -->
<jsp:include page="footer.jsp" />  