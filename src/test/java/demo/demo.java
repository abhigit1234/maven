package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
public static void main(String[] args)  {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:90/opencart/upload/admin");
	System.out.println("abhilash babu durgumahanthi");
	



}



}
