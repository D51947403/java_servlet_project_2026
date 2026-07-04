package org.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         response.setContentType("text/html");

                 String name = request.getParameter("name");
                 
                 String address =request.getParameter("address");
                 
               //if request is not from HttpServletRequest
                 HttpSession session = request.getSession();
                 //save message in session
                 session.setAttribute("name", name);
                 
                 session.setAttribute("address", address);
                 
                 session.setAttribute("servletName", "UserServlet");
                 
                 session.setAttribute("age", 35);
                 
                 response.sendRedirect("user.jsp");
	         
	}

}
