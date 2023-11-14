package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass {

	
	@Test
	public void Test() throws IOException 
	{
		logger.info("brower is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("enter username");
		lp.setPass(password);
		logger.info("enter username");
		lp.loginBtn();
		logger.info("click on  submit button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("test is passed");
		}else {
			captureScreen(driver,"Login");
			Assert.assertTrue(false);
			logger.info("test is failed");
		}
	}
	
	
	
}
