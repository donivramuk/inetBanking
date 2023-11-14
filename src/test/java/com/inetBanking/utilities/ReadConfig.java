package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		File src = new File(".//Configuration//config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception ex) {
			System.out.println("Staus message "+ ex.getMessage());
			
		}
		
	}
	
	public String setBaseURL() {
		String baseurl = pro.getProperty("baseURL");
		return baseurl;
	}
	public String setUserName() {
		String uname = pro.getProperty("uname");
		return uname;
	}
	public String setPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}

}
