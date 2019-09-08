package com.ios.fastip.testcases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class TestCases extends BaseClass {	
	
	@Test(priority=1)
	public void testBillAmount() {
		
		homepage.calculate("1000");
		
		assertEquals("$150.00",homepage.getTipAmount());
		assertEquals("$1150.00", homepage.getTotalAmount());
	}
	
	@Test(priority=2)
	public void testtipPercentageChangedisReflectedInHomeScreen() {
		
		homepage.clickSettings();
		settingspage.changetipPercentage("20");
		
		assertEquals("20%",homepage.gettipPercentage());
		assertEquals("$200.00",homepage.getTipAmount());
		assertEquals("$1200.00", homepage.getTotalAmount());
	}
	
	@Test(priority=3)
	public void testPercentageShouldthrowAlertWhenStringisEntered() {

		homepage.clickSettings();
		settingspage.changetipPercentage("ABCD");
		
		assertEquals("Incorrect Number Format", settingspage.getAlertTitle());
		assertEquals("A decimal value is required",settingspage.getAlertMessage());
		settingspage.clickAlertOK();
				
	}
	

}
