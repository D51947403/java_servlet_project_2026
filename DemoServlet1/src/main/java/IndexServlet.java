

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 * 
 * http://localhost:8080/DemoServlet1/
 */
 
@WebServlet(description = "IndexServlet", urlPatterns = { "/" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
 	   
 	   PrintWriter out=response.getWriter(); // get the stream to write data
 	 //writing html in the stream  
 	   out.println("<html><body>");  
 	   out.println("Welcome to Index Servlet");  
 	   out.println("<a href=\"/DemoServlet1/DeadLockServlet\"> Deadlock1 </a>.");
 	   out.println("<a href=\"DeadLockServlet\"> Deadlock 2</a>");  
	   out.println("<a href=\"./DeadLockServlet\"> Deadlock 3</a>");  
 	   out.println("<a href=\"demo-servlet\"> DemoServlet</a>");  
	  
 	   out.println("</body></html>"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
