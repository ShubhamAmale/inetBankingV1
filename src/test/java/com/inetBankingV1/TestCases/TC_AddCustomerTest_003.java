package com.inetBankingV1.TestCases;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.AddCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	

	@Test
	public void addNewCustomer() throws  InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("TC003_Username is provided");
		lp.setPassword(password);
		logger.info("TC003_Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		String originalWindow = driver.getWindowHandle();
		System.out.println(originalWindow);
		logger.info("TC003_Click on Add Customer...");
		addcust.clickAddNewCustomer();
		//handled google ads frame
		WebElement adframe = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(adframe);
		driver.findElement(By.id("dismiss-button")).click();
		driver.switchTo().defaultContent();
		logger.info("TC003_Providing customer details...");
		addcust.custName("Shubham");
		addcust.custGender("male");
		addcust.custdob("04", "25", "1997");
		Thread.sleep(3000);
		addcust.custaddress("Narhe");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno(411041);
		addcust.custtelephoneno("24591329045");		
		
		String email = randomstring()+ "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcd1234");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("TC003_Validation started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res = true) {
			Assert.assertTrue(true);
			logger.info("TC003_Test Case Passed...");
			logger.info("TC003_Customer_id: "+addcust.getCustId());
		}
		else {
			
			logger.info("TC003_Test Case Failed...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}
	}
	
}
