package demo;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URI;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshMethods {
public static void main(String[] args)throws Exception {
	
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com");
	
	//Method 1
	
	driver.navigate().refresh();
	
	//Method 2
	
	driver.get(driver.getCurrentUrl());
	

	//Method 3
	
	driver.navigate().to(driver.getCurrentUrl());
	

	//Method 4
	
	driver.navigate().to(new URI(driver.getCurrentUrl()).toURL());
			
			

	//Method 5
	
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_R);
	
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_R);
	
	
	//Method 6
	
	((JavascriptExecutor)driver).executeScript("window.location.reload(true)"); 
	

	
}
}
