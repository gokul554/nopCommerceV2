package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException {
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		logger.info("Login button is clicked");
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) 
		{
			Assert.assertTrue(true);
			logger.info("Page title is matched, Dashboard page is opened.");
			lp.clickLogout();
			logger.info("logout button is clicked");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path ="E://Eclipse Files/nopCommerceV2/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
        String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}

}
