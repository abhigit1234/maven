package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POM_FirstMethod_2{


public static void main(String[] args) throws InterruptedException {
	

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		
		POM_FirstMethod_1 p = new POM_FirstMethod_1(driver);
		
		p.fname("abhi");
		p.lname("naidu");
		p.email("abhi@gmail");
		p.setpassword("123456");
		p.setday();
		p.setmonth();
		p.setyear();
		Thread.sleep(2000);
		p.radio();
	
	
	
}}