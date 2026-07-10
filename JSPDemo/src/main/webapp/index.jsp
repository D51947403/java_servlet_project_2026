<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My First Jsp Page</title>
</head>
<body>

<%!   
 boolean flag=true; 
%> 

<h2>Scriptlet Tag example (Method level code)</h2>
<% out.print(2*5+100);
if (flag){
	out.print("Hi");
	System.out.println("test");
}
%>   


<h2>JSP expression Tag example (Method level code)</h2>

<%= "Welcome to My First jsp page" %>

<br/> <br/>

Current Time: <%= java.util.Calendar.getInstance().getTime() %>


<h2>JSP Declaration Tag example (Class level code)</h2>

<%!   
int cube(int n){  
return n*n*n;  
}  
%>  

<%= "Cube of 3 is:"+cube(3) %>  

<h2>Form </h2>

<form action="welcome.jsp">  
<input type="text" name="uname"><br/>  
<input type="submit" value="Welcome">  
</form>    

 

</body>
</html>