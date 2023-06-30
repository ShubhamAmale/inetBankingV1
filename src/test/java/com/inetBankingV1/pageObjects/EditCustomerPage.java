package com.inetBankingV1.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCustomerPage {

	WebDriver ldriver;
	
	public EditCustomerPage (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[3]/a")
	WebElement lnkeditcustomer;
	
	public void EditCustomer() {
		lnkeditcustomer.click();
	}
	
	@FindBy(name = "AccSubmit")
	WebElement accbtn;
	
	public void accept() {
		accbtn.click();
	}
	
	@FindBy(name = "cusid")
	WebElement custid;
	
	public void addcustId(int cid) {
		custid.sendKeys(String.valueOf(cid));
	}
	
	@FindBy(name = "state")
	WebElement state;
	
	public void editState(String cstate) {
		state.clear();
		state.sendKeys(cstate);
	}
	
	@FindBy(name = "emailid")
	WebElement cemailId;
	
	public void editEmailId(String ceid) {
		cemailId.clear();
		cemailId.sendKeys(ceid);
	}
	
	@FindBy(name=  "sub")
	WebElement submit;
	
	public void clkSubmit() {
		submit.click();
	}
}
