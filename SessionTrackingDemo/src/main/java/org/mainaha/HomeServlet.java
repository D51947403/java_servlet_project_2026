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
@WebServlet(urlPatterns = "/home" ,description = "HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
			      
			    String userName= null;
				String userPass=null;
				String userId =null;
					    
				 out.print("<br>");
				 out.print("Home Servlet get method");
				    
			    Cookie ck[] = request.getCookies();  
			    
			    for(int i = 0; i < ck.length; i++) {  
			        out.print("<br>" + ck[i].getName() + " " + ck[i].getValue());  
			    }  
			    userName =ck[0].getValue();
			    userId=ck[1].getValue();
			    userPass=ck[2].getValue();
			   
			    out.print("<br>");
			    out.print("Welcome "+userName +"[ "+userId+" ]"); 
			    
			    System.out.println("userPass "+userPass);
			    
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
		 try{  
		response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String clientName=request.getParameter("clientName");  
		    String clientPass=request.getParameter("clientPass");  
		    String clientId =request.getParameter("clientId"); 
		    
		    System.out.println("clientPass "+clientPass);
		    
		    out.print("<br>");
			 out.print("Home Servlet post method");
		  
		    out.print("<br>");
		    out.print("Welcome: "+clientName +" [ "+clientId+" ]"); 
		    
		    out.print("<br>");
		    out.print("<br>");
		    out.print(" <a href='/SessionTrackingDemo/index.html' accesskey='1' title='Index Page'>Index Page</a>");
		  
		    out.close();
		 }catch(Exception e){System.out.println(e);}  
	}
	

}
