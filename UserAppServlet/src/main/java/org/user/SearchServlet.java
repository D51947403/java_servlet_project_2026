package org.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   System.out.print("calling to serach servlet");
		String name=request.getParameter("name");  
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    out.print("Serach Servlet "+name);  
        out.print("<br/> will serach in google");
	    response.sendRedirect("https://www.google.co.in/#q="+name);  
	}

}
