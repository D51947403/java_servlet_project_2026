import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/DemoServlet1/demo-servlet
 */
public class DemoServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request , HttpServletResponse response) throws ServletException ,
       IOException{
    	   
    	   response.setContentType("text/html");
    	   
    	   PrintWriter out=response.getWriter(); // get the stream to write data
    	 //writing html in the stream  
    	   out.println("<html><body>");  
    	   out.println("Welcome to Demo servlet");  
    	   out.println("This is demo servlet example.");
    	   out.println("</body></html>"); 
    	   
    	   out.close();
       }
}
