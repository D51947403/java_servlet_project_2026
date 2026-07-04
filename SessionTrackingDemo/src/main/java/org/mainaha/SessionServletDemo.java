package org.mainaha;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieServletDemo
 */
@WebServlet(urlPatterns = "/guestLogin" ,description = "guestLogin")
public class SessionServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServletDemo() {
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
		          
		    String guestName=request.getParameter("guestName");  
		    String guestPass=request.getParameter("guestPass");  
		    
		    // Code to generate 4 digit random number 
		    BigDecimal bd = new BigDecimal(Math.random());
		   // Set scale to 4 decimal places and define a rounding rule
		    bd = bd.setScale(4, RoundingMode.HALF_UP);
		    System.out.println(bd);
		    int randomNum =(int) (bd.doubleValue()*10000+20);
		    System.out.println(randomNum);
		    String guestId ="GUEST"+String.valueOf(randomNum);
		    
		    System.out.println("guestPass "+guestPass);
		    
		  //if request is not from HttpServletRequest
		    // create new session if not exists
            HttpSession session = request.getSession();
            // create always new session
           // HttpSession sessionTrue = request.getSession(true);
            // Always use existing session
            // HttpSession sessionFalse = request.getSession(false);
            
            //save message in session
            session.setAttribute("guestName", guestName);
            
            session.setAttribute("guestId", guestId);
            
            ArrayList <Integer> numList = new ArrayList<>(); 
            
            numList.add(100); numList.add(200); numList.add(300);
            // Storing ArrayList
            session.setAttribute("numList", numList);
            
            GuestDetail guestDetail =new GuestDetail();
            guestDetail.setGuestName(guestName);
            guestDetail.setGuestCity("Maihar");
            guestDetail.setGuestId(guestId);
            // storing object
            session.setAttribute("guestDetail", guestDetail);
		    
		    
		    out.print("<br>");
		    out.print("Welcome: "+guestName +" [ "+guestId+" ]"); 
		    
		    out.print("<br>");
		    out.print("<br>");

		  //appending the adminName in the query string  
	        out.print("<a href='guest'>Guest Page</a>");
		    out.print("<br>");
		          
		    out.close();  
		  
		        }catch(Exception e){System.out.println(e);}  
		  }  
	

}
