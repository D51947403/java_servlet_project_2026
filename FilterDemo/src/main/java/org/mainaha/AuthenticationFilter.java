package org.mainaha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class PreProcessFilter
 */
@WebFilter(
	    urlPatterns = { "/admin"},
	    initParams = {
	        @WebInitParam(name = "adminUser", value = "Ashok"),
	        @WebInitParam(name = "adminPass", value = "admin123")
	    }
	)
public class AuthenticationFilter extends HttpFilter implements Filter {
       
	  private String adminUser;
	  private String adminPass;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter init method");
		 // Retrieve values by parameter name
        this.adminUser = fConfig.getInitParameter("adminUser");
        
        this.adminPass = fConfig.getInitParameter("adminPass");
    
        
	}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();  
	    out.print("AuthenticationFilter filter is invoked");  
	  
	   
	    //coming from user form
	      String name=request.getParameter("name"); 
		  String password=request.getParameter("password");  
		    if(name.equals(this.adminUser) && password.equals(this.adminPass)){  
		    	 // Pass the parameters forward to the servlet 
		    request.setAttribute("adminUser", this.adminUser);
		    chain.doFilter(request, response);//sends request to next resource  
		    }  
		    else{  
		    out.print("   username or password error!");   
		    RequestDispatcher rd=request.getRequestDispatcher("error.html");  
		    rd.include(request, response);  
		    }  
	}


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("AuthenticationFilter destroy method");
	}

}
