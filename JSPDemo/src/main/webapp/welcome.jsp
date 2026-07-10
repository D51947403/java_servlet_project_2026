<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Welcome Jsp Page</title>
</head>
<body>

<h2>JSP expression Tag example (Method level code)</h2>

<%= "Welcome "+request.getParameter("uname") %>   

 <br/>  <br/>  
<a href="/JSPDemo/index.jsp">Index JSP</a> 

</body>
</html>