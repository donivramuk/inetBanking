package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver dr) {
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="uid")
	WebElement userName;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(name ="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	
	public void setUserName(String uname) {
		userName.sendKeys(uname);
		
	}
	public void setPass(String pass) {
		password.sendKeys(pass);
		
	}
	public void loginBtn() {
		loginBtn.click();
		
	}
	public void logout() {
		logout.click();
		
	}
	
	
	
}
