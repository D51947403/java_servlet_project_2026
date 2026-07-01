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
@WebServlet(urlPatterns = "/clientLogin" ,description = "HiddenFormServletDemo")
public class HiddenFormServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenFormServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
			  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String clientName=request.getParameter("clientName");  
		    String clientPass=request.getParameter("clientPass");  
		    String clientId =request.getParameter("clientId"); 
		    
		    System.out.println("clientPass "+clientPass);
		    
		  
		    out.print("<br>");
		    out.print("Welcome: "+clientName +" [ "+clientId+" ]"); 
		    
		  
		    out.print("<br>");
		    //creating submit button  
		    out.print("<form action='home' method='post'>");  
		    out.print("<input type='submit' value='Home'>");  
		    out.print("<input type='hidden' name='clientId' value='"+clientId+"'>");
		    out.print("<input type='hidden' name='clientName' value='"+clientName+"'>");
		    out.print("<input type='hidden' name='clientPass' value='"+clientPass+"'>");
		    out.print("</form>");  
		    out.print("<br>");
		          
		    out.close();  
		  
		        }catch(Exception e){System.out.println(e);}  
		  }  
	

}
