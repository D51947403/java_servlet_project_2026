package com.emp.system.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ApputilTest {

	@Test
	public void testContainsDigit() {
		boolean flag = AppUtil.containsDigit("Devendra123");
		
		assertTrue(flag);
		
		assertTrue(AppUtil.containsDigit("Devendra123"));
		
		assertEquals(true, flag);
		
		assertEquals(true, AppUtil.containsDigit("Devendra123"));
	}

}
