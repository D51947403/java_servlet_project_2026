

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(description = "Index Servlet", urlPatterns = { "/" })
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
		System.out.println("Welcome to Index Servlet");
		
		 response.setContentType("text/html");
  	   
  	   PrintWriter out=response.getWriter(); // get the stream to write data
  	 //writing html in the stream  
  	   out.println("<html><body>");  
  	   out.println("Welcome to Index servlet");  
  	   out.println("<form action=\"welcome\" method=\"get\">  \r\n"
  	   		+ "Enter your name<input type=\"text\" name=\"name\"><br>  \r\n"
  	   		+ "<input type=\"submit\" value=\"submit\">  \r\n"
  	   		+ "</form>  ");
  	   out.println("</body></html>"); 
  	   
  	   out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
