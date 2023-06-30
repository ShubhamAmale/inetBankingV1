package com.inetBankingV1.pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	public void clickAddNewCustomer() {
		new WebDriverWait(ldriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(lnkAddNewCustomer));
		lnkAddNewCustomer.click();
	}
	
	@FindBy(name = "name")
	WebElement txtCustomerName;
	
	@FindBy(name = "rad1")
	WebElement rdGender;
	
	@FindBy(name = "dob")
	WebElement txtdob;

	@FindBy(name = "addr")
	WebElement txtaddress;
	
	@FindBy(name = "city")
	WebElement txtcity;
	
	@FindBy(name = "state")
	WebElement txtstate;
	
	@FindBy(name = "pinno")
	WebElement txtpinno;
	
	@FindBy(name = "telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(name = "emailid")
	WebElement txtemailid;
	
	@FindBy(name = "password")
	WebElement txtpassword;
	
	@FindBy(name = "sub")
	WebElement btnSubmit;
	
	@FindBy(how = How.XPATH, using= "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]")
	WebElement custid;
	
	
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	public void custpinno(int cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno)); //sendkeys accepts only String
	}
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	public String getCustId() {
		String cid = custid.getText();
		return cid;
	}
	
}
