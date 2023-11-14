package com.inetBanking.utilities;

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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class Reporting extends TestListenerAdapter 
{
	public ExtentSparkReporter spark ;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext context) 
	{
		String timestamp = new SimpleDateFormat("YYYY-MM-DD HH-MM-SS").format(new Date());
		String repname = "Test-Report -" +timestamp + ".html";
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repname);
		
		try {
			spark.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Env", "QA");
		extent.setSystemInfo("user", "vin");
		
		spark.config().setDocumentTitle("inetBanking");
		spark.config().setReportName("Functional report");
		spark.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult r) 
	{
		logger = extent.createTest(r.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(r.getName(), ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult r) 
	{
		logger = extent.createTest(r.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(r.getName(), ExtentColor.RED));
		String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+r.getName()+".png";
		File f = new File(screenshotpath);
		if(f.exists()) 
		{
			try {
				logger.fail("Screenshot is below" +logger.addScreenCaptureFromPath (screenshotpath));
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
		}
		
	}

	public void onTestSkipped(ITestResult r) 
	{
		logger = extent.createTest(r.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(r.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
	
}
