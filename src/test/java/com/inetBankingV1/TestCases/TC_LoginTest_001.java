
package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		driver.get(baseURL);
		
		logger.info("TC_001_URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		BaseClass.logger.info("TC001_Username Entered");
		lp.setPassword(password);
		BaseClass.logger.info("TC001_Password Entered");
		
		lp.clickSubmit();
		Thread.sleep(5000);
		BaseClass.logger.info("TC001_Clicked on Submit");
		Thread.sleep(5000);
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			BaseClass.logger.info("TC001_Loggin Test Passed");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			BaseClass.logger.info("TC001_Loggin Test Failed");
		}
	
	}
}


