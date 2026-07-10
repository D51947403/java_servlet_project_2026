package com.listenerdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtil {

	public AppUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String getCurrentDate() {
        Date today = new Date();
        
        // Define the pattern with capital MM for month
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(today);
        System.out.print("formattedDate :"+formattedDate);
        return formattedDate;
	}
	
	public static void main(String args[]) {
		getCurrentDate();
	}
}
