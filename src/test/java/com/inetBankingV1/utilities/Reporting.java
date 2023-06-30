package com.inetBankingV1.utilities;
//Listener Class used to generate the Extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat ("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timestamp+".html";
		htmlReporter=new ExtentHtmlReporter("E:\\SeleniumProject_V1\\inetBankingV1\\target"+repName);
		//saved report with report name as repName with timestamp
		htmlReporter.loadXMLConfig("E:\\SeleniumProject_V1\\inetBankingV1\\extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Shubham_Amale");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Automation Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	
		String screenshotPath = "E:\\SeleniumProject_V1\\inetBankingV1"+tr.getName()+".png";
     File f = new File(screenshotPath);
     if(f.exists())
     {
    	 try {
    		 logger.fail("Screenshot is below: "+logger.addScreenCaptureFromPath(screenshotPath));
    	 }
    	 catch(IOException e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     
	}
	
	public void onTestSkipped(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
