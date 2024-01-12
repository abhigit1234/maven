package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class demo {
public static void main(String[] args)  {
	
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("https://www.google.com");
	
	



}



}
