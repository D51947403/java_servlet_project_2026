package org.mainaha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class PreProcessFilter
 */
public class PostProcessFilter extends HttpFilter implements Filter {
      
	 private String databaseName;
	 private String databaseType;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public PostProcessFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("PostProcessFilter init method");
		
		 this.databaseName = fConfig.getInitParameter("databaseName");
		 this.databaseType = fConfig.getInitParameter("databaseType");
	        
	    
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();  
	    out.print("PostProcessFilter filter is invoked");  
	    out.print("<br/>");  
	    out.print("databaseName : "+this.databaseName );  
	    out.print("<br/>");  
	    out.print("databaseType : "+this.databaseType ); 
	    out.print("<br/>"); 
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("PostProcessFilter destroy method");
	}
}
