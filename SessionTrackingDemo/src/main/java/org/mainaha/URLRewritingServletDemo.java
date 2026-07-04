package org.mainaha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServletDemo
 */
@WebServlet(urlPatterns = "/adminLogin" ,description = "URLRewritingServletDemo")
public class URLRewritingServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URLRewritingServletDemo() {
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
		          
		    String adminName=request.getParameter("adminName");  
		    String adminPass=request.getParameter("adminPass");  
		    String adminId ="ADMIN2222"; 
		    
		    System.out.println("adminPass "+adminPass);
		    
		  
		    out.print("<br>");
		    out.print("Welcome: "+adminName +" [ "+adminId+" ]"); 
		    
		    out.print("<br>");
		    out.print("<br>");

		  //appending the adminName in the query string  
	        out.print("<a href='admin?adminName="+adminName+"&adminId="+adminId+"'>Admin Page</a>");
		    out.print("<br>");
		          
		    out.close();  
		  
		        }catch(Exception e){System.out.println(e);}  
		  }  
	

}
