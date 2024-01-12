package demo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;



import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launch {
	public static WebDriver driver;
	public static String browser = "chrome";

	public static void main(String[] args) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://www.blazedemo.com/login");

		WebElement emailid = driver.findElement(By.id("email"));
		emailid.sendKeys("abhilashnaidu21@gmail.com");

		driver.findElement(RelativeLocator.with(By.tagName("input")).below(emailid)).sendKeys("naidu123");
		
		
	}
}
