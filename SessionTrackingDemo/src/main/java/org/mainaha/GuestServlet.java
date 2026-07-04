package org.mainaha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieServletDemo
 */
@WebServlet(urlPatterns = "/guest" ,description = "GuestServlet")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try{  
			  
			    response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			      // Always use existing session 
			    HttpSession session=request.getSession(false); 
			    
			 // Retrieving String
		        String guestName=(String)session.getAttribute("guestName");  
		        String guestId =(String)session.getAttribute("guestId");
		        
		        out.print("Welcome "+guestName +"[ "+guestId+" ]"); 
		        out.print("<br>");
				 out.print("<br>");
				 
		        // Retrieving ArrayList
		        ArrayList <Integer> numList =(ArrayList <Integer>)session.getAttribute("numList");
		        
		        for(Integer num :numList) {
		        	System.out.println(num);
		        }
		        
		        // Retrieving Object
		        GuestDetail guestDetail=(GuestDetail)session.getAttribute("guestDetail");
					
		        
				 out.print("Guest Servlet get method");
				 out.print("<br>");
				 out.print("Guest Name: "+guestDetail.getGuestName()); 
				 out.print("<br>");
				 out.print("Guest City: "+guestDetail.getGuestCity()); 
				 out.print("<br>");
				 out.print("Guest Id: "+guestDetail.getGuestId()); 
			     out.print("<br>");
			  
			    
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
