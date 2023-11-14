package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class BaseClass {

	ReadConfig rc = new ReadConfig();
	public String baseURL = rc.setBaseURL();
	public String uname =rc.setUserName();
	public String password =rc.setPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	public void captureScreen(WebDriver driver,String name) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tar = new File(System.getProperty("user.dir")+ "/Screenshots/"+name +".png");
		FileUtils.copyFile(src, tar);
		System.out.println("Screenshot taken");
		
	}
	public String Randomstring() 
	{
		String randomst = RandomStringUtils.randomAlphabetic(9);
		return randomst;
		
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.get(baseURL);
		
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
	
	
	
}
