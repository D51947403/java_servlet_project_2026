package com.emp.java;


import com.emp.crud.Util;

public class UtilTest {
	
public static void main (String args[]) {
	
	String name ="DEVENDRA123";
	
	boolean flag =Util.containsDigit(name);
	System.out.println("Should be true: "+flag);
}
	
}


