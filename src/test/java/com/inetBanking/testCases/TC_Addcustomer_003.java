package com.inetBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.Addcustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_Addcustomer_003 extends BaseClass
{
	
	@Test
	public void Test() throws IOException, InterruptedException {
	LoginPage lp = new LoginPage(driver);
	logger.info("Enter username");
	lp.setUserName(uname);
	logger.info("Enter Password");
	lp.setPass(password);
	logger.info("Click on Submit button");
	lp.loginBtn();	
	Thread.sleep(3000);
	Addcustomer adc = new Addcustomer(driver);
	adc.Addcustomerlink();
	Thread.sleep(3000);
	logger.info("Enter Customer Name");
	adc.Setcustomername("rajkumar");
	logger.info("Selecting gender");
	adc.Setgender();
	adc.Setdob("10", "14", "1994");
	logger.info("Set Date of Birth");
	adc.Setaddress("Bangalore Karnataka");
	logger.info("Enter the Address");
	adc.Setcity("SetBangalore");
	logger.info("Enter city");
	adc.Setstate("Karnataka");
	logger.info("Enter State");
	adc.Setpincode("560017");
	logger.info("Enter pincode");
	adc.Setphone("9749432104");
	logger.info("Enter Phonenumber");
	String Email = Randomstring()+"@gmail.com";
	logger.info("Enter the email");
	adc.Setemail(Email);
	adc.Setpassword("Bhdndf@1A");
	logger.info("Enter the password");
	adc.clicksubmit();
	Thread.sleep(5000);
	
	if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
	{
		logger.info("test is passed");
		Assert.assertTrue(true);
	}else {
		logger.info("test is failed");
		captureScreen(driver,"TC_Addcustomer_003");
		Assert.assertTrue(false);
	}
	
	
	}
	
}
