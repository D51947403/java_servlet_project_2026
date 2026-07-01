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
@WebServlet(urlPatterns = "/userLogin" ,description = "CookieServletDemo")
public class CookieServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServletDemo() {
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
		          
		    String userName=request.getParameter("userName");  
		    String userPass=request.getParameter("userPass");  
		    String userId ="ABC123";
		    
		    System.out.println("userPass "+userPass);
		    
		    out.print("CookiesServlet");
		    out.print("<br>");
		    out.print("Welcome: "+userName +" [ "+userId+" ]"); 
		    
		    Cookie userCookie=new Cookie("userName",userName);//creating cookie object  
		    Cookie idCookie=new Cookie("userId",userId);//creating cookie object  
		    Cookie passCookie=new Cookie("userPass",userPass);//creating cookie object  
		    
		    response.addCookie(userCookie);//adding cookie in the response  -- 0
		    response.addCookie(idCookie);//adding cookie in the response  --1
		    response.addCookie(passCookie);//adding cookie in the response --2 
		  
		    out.print("<br>");
		    //creating submit button  
		    out.print("<form action='home'>");  
		    out.print("<input type='submit' value='Home'>");  
		    out.print("</form>");  
		    out.print("<br>");
		          
		    out.close();  
		  
		        }catch(Exception e){System.out.println(e);}  
		  }  
	

}
