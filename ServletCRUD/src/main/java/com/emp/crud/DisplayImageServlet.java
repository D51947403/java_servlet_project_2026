package com.emp.crud;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayImage
 */
@WebServlet("/displayImage")
public class DisplayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  public void doGet(HttpServletRequest request,HttpServletResponse response)  
	             throws IOException  
	    {  
	    response.setContentType("image/jpeg");  
	    ServletOutputStream out;  
	    out = response.getOutputStream();  
	  
	    // 1. Define the relative path starting from the root of the classpath  
	    // file is inside src/main/resources under images folder 
        String resourcePath = "images/devendra_image.jpeg";
	    InputStream fin =  Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
	      
	    BufferedInputStream bin = new BufferedInputStream(fin);  
	    
	    BufferedOutputStream bout = new BufferedOutputStream(out);  
	    int ch =0; ;  
	    while((ch=bin.read())!=-1)  
	    {  
	    bout.write(ch);  
	    }  
	      
	    bin.close();  
	    fin.close();  
	    bout.close();  
	    out.close();  
	    }  
}
