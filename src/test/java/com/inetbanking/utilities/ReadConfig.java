package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	

	
	public static Properties p;
	public static FileInputStream fis;
	
	public ReadConfig()  {
			
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			p= new Properties();
			p.load(fis);
				
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getBrowser() {
	String browser = 	p.getProperty("browser");
	return browser;
	}

	public String getUrl() {
	String url = 	p.getProperty("baseurl");
	return url;
	}
	public String getUsername() {
		String user_name = p.getProperty("user_name");
		return user_name;
	}
	public String getPassword() {
		String user_pswd = p.getProperty("user_password");
		return user_pswd;
	}
	public String clickLogin() {
		String btn = p.getProperty("login_btn");
				return btn;
	}
	
	
	
	
}
