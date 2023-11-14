package com.inetBanking.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Addcustomer 
{
	WebDriver driver;
	
	public Addcustomer(WebDriver dr) 
	{
		this.driver =dr;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	private WebElement Addcustomerlink ;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	private WebElement Customername ;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	private WebElement gender ;
	
	@FindBy(how=How.NAME, using="dob")
	@CacheLookup
	private WebElement Dob ;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	private WebElement Address ;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	private WebElement City ;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	private WebElement State ;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	private WebElement Pinno ;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	private WebElement MobileNumber ;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	private WebElement EmailId ;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	private WebElement Password ;
	
	@FindBy(how=How.XPATH, using="//tbody/tr[14]/td[2]/input[1]")
	@CacheLookup
	private WebElement Submit ;
	
	public void Addcustomerlink() 
	{
		Addcustomerlink.click();
	}
	public void Setcustomername(String cname) 
	{
		Customername.sendKeys(cname);
	}
	
	public void Setgender() 
	{
		gender.click();
	}
	public void Setdob(String mm,String dd,String yy) 
	{
		Dob.sendKeys(mm);
		Dob.sendKeys(dd);
		Dob.sendKeys(yy);
	}
	
	public void Setaddress(String address) 
	{
		Address.sendKeys(address);
	}
	
	public void Setcity(String city) 
	{
		City.sendKeys(city);
	}
	
	public void Setstate(String state) 
	{
		State.sendKeys(state);
	}
	
	public void Setpincode(String pin) 
	{
		Pinno.sendKeys(pin);
	}
	public void Setphone(String phone) 
	{
		MobileNumber.sendKeys(phone);
	}
	
	
	public void Setemail(String email) 
	{
		EmailId.sendKeys(email);
	}
	public void Setpassword(String pass) 
	{
		Password.sendKeys(pass);
	}
	
	public void clicksubmit()
	{
		Submit.click();
	}
	
	

}
