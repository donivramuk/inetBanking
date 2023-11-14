package com.inetBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XlUtility;

public class TC_LoginData_002  extends BaseClass
{
	
	
	public boolean isAlertpresent() 
	{
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	@Test(dataProvider ="logindata")
	public void LoginData(String uname,String pass) 
	{
	 LoginPage lp = new LoginPage(driver);
	logger.info("Enter Username");
	 lp.setUserName(uname);
	 logger.info("Enter password");
	 lp.setPass(pass);
	 logger.info("click on submit button");
	 lp.loginBtn();
	 if(isAlertpresent()==true) {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		 Assert.assertTrue(false);
	 }else {
		 Assert.assertTrue(true);
		 lp.logout();
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 
	 }
	 
	}
	@DataProvider(name="logindata")
	String [][] getdata() throws IOException{	
		String path = System.getProperty("user.dir")+ "/src/test/java/com/inetBanking/testData/Testdata.xlsx";
		XlUtility xl = new XlUtility();
		int rowcount = xl.getRowcount(path,"Sheet1");
		int colcount = xl.getCellcount(path,"Sheet1", 1);
		String [][] LoginData  = new String [rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				LoginData[i-1][j] = xl.getCellData(path, "Sheet1",i, j);
			}
			
		}
		return LoginData;
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
