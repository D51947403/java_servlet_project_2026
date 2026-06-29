package org.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
//@WebServlet(urlPatterns = {"/admin", "/admin/*"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String pathInfo = request.getPathInfo(); // Returns e.g., "/Devendra/Puna/35"
        
        if (pathInfo == null || "/".equals(pathInfo)) {
        	System.out.println("path parameter required");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing path parameter required");
            return;
        }
        
        String userName=null;  
        String address=null;  
        String age=null;

        // Split the path info by "/"
        // Array looks like: ["", "Devendra", "Puna","35"] because it starts with a slash
        String[] pathParts = pathInfo.split("/"); 
        
        if (pathParts.length > 1) {
             userName = pathParts[1]; // Retrieves "Devendra"
             address = pathParts[2]; // Retrieves "Puna"
             age = pathParts[3]; // Retrieves "35"
            // Use the extracted path parameter
            System.out.println("userName is: " + userName);  
            System.out.println("address is: " + address);
            System.out.println("age is: " + age);
        }
        
        out.print("Welcome to admin screen "+userName); 
        out.print("<br/> Welcome to admin screen "+address);  
        out.print("<br/> Welcome to admin screen "+age); 
        
        out.close();  
  
                }catch(Exception e){System.out.println(e);}  
    } 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		 PrintWriter out= response.getWriter();
		 
		 out.print("<html> <body> This is admin servlet</body></html>");
		 
	}
	
	
	

}
