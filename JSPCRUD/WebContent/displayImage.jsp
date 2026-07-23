<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.BufferedOutputStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="javax.servlet.ServletOutputStream" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>

<%!	 
// Instantiate the logger using the current generated Servlet class name
private  final Logger LOGGER  = Logger.getLogger(this.getClass().getName());
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
    	LOGGER.info("POST Method ");
    } 
    else if (httpMethod.equals("PUT")) {
        // UPDATE Operation
    	LOGGER.info("PUT Method ");
        
    } 
    else if (httpMethod.equals("DELETE")) {
    	 // DELETE Operation
    	LOGGER.info("DELETE Method ");
      
    }else{
    	 // GET falls through naturally to render the UI below
    	LOGGER.info("GET Method ");
    	displayImage( request, response) ;
    }	
   
%>

 <%!
 private void displayImage(HttpServletRequest request,HttpServletResponse response)  throws IOException
 {  
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

 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Display Image JSP</h1>
</body>
</html>