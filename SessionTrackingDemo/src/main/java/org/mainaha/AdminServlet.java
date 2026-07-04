package org.mainaha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServletDemo
 */
@WebServlet(urlPatterns = "/admin" ,description = "AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try{  
			  
			    response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			      
			    String adminName=request.getParameter("adminName");  
			    String adminId =request.getParameter("adminId");  
					    
				 out.print("<br>");
				 out.print("Admin Servlet get method");
				    
			   
			    out.print("<br>");
			    out.print("Welcome "+adminName +"[ "+adminId+" ]"); 
			    
			    out.print("<br>");
			    out.print("<br>");
			    out.print(" <a href='/SessionTrackingDemo/index.html' accesskey='1' title='Index Page'>Index Page</a>");
			    
			    out.close(); 
			  
			 }catch(Exception e){System.out.println(e);}  
			    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
