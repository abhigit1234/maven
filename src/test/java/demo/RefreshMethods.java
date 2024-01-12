package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshMethods {
public static void main(String[] args)throws Exception {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com");
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(2000);
	driver.navigate().to("https://www.google.com");
	Thread.sleep(2000);
	driver.navigate().to(driver.getCurrentUrl());
	driver.findElement(By.name("q")).sendKeys(Keys.F5);
}
}
