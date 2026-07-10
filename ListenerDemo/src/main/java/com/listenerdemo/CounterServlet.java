package com.listenerdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet(description = "CounterServlet", urlPatterns = { "/CounterServlet" })
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");

	        PrintWriter out = response.getWriter();
	        ServletContext ctx = getServletContext();

	        Integer count = (Integer)ctx.getAttribute("pageCount");

	        out.println( "<h2>CounterServlet </h2> <br/>");
	        out.println(count + ": pageview");
	        // incrementing counter value here
	        ctx.setAttribute("pageCount", ++count);
	        out.println( "<br/> <br/>");
	        
	        out.println("<a href='index.html'>Index Page</a>");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
