package com.inetBankingV1.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.EditCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass{

	@Test
	public void editCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("TC004_Username is provided");
		lp.setPassword(password);
		logger.info("TC004_Password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		EditCustomerPage ec = new EditCustomerPage(driver);
		logger.info("TC004_Click on Edit Customer");
		ec.EditCustomer();
		//google add id = "card"
		//google close id = "dismiss-button"
		//cust id = 	47060
		WebElement adsbygoogle = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(adsbygoogle);
		driver.findElement(By.id("dismiss-button")).click();
		driver.switchTo().defaultContent();
		
		ec.addcustId(98898);
		ec.accept();
		ec.editEmailId("jwis95@gmail.com");
		logger.info("TC004_Email id editted");
		ec.editState("New Jersey");
		logger.info("TC004_State id editted");
		ec.clkSubmit();
		logger.info("TC004_Changes submitted");
		
		String alerttxt = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		logger.info("TC004_Alert accepeted");
	}	
}
