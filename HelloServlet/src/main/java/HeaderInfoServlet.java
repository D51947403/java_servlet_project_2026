

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import java.util.*;  

/**
 * Servlet implementation class HeaderInfoServlet
 */
@WebServlet(description = "HeaderInfoServlet", urlPatterns = { "/headerinfo" })
public class HeaderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest req,  
            HttpServletResponse res)  
            throws ServletException, IOException {  
  
        res.setContentType("text/html");  
  
        PrintWriter out = res.getWriter();  
  
        out.println("<html><body>");  
  
        out.println("<h2>Request Header Information</h2>");  
  
        Enumeration headerNames = req.getHeaderNames();  
  
        while(headerNames.hasMoreElements()) {  
  
            String header = (String)headerNames.nextElement(); 
           // sec-fetch-site
          //host 
            String value = req.getHeader(header);  
            //none
            // localhost:8080
            out.println("<b>" + header + "</b> : "  
                    + value + "<br>");  
        }  
  
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
