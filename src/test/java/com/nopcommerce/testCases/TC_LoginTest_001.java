package com.nopcommerce.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Login button is clicked");
		
		Thread.sleep(3000);
		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) 
		{
			logger.info("Page title is matched, Dashboard page is opened.");
			Assert.assertTrue(true);
			
			lp.clickLogout();
			logger.info("logout button is clicked");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("login failed");
		}
	}
	
	
	
	
}


