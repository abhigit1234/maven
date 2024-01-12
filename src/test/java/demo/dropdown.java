package demo;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


		driver.get("https://www.facebook.com/signup");
		
		WebElement day = driver.findElement(By.id("day"));
		day.click();
		Select d1 =  new Select(day);
		d1.selectByValue("21");
		
		
		WebElement month = driver.findElement(By.id("month"));
		month.click();
		Select m1 = new Select(month);
		m1.selectByValue("6");
		month.getAttribute("select");
		
		WebElement year=driver.findElement(By.id("year"));
		year.click();
		
		Select y1 = new Select(year);
		y1.selectByValue("1989");
		
		driver.findElement(By.name("websubmit")).click();
		
		

		
/////////////////////////////////////////////////////////////////////////////////////////		
		
		driver.get("https://www.blazedemo.com");
	
	WebElement option = driver.findElement(By.name("fromPort"));
	option.click();
	
	Select select = new Select(option);
	select.selectByValue("San Diego");
	
	
	WebElement option1 = driver.findElement(By.name("toPort"));
	option1.click();
	Select select1 = new Select(option1);
	select.selectByIndex(3);
	
	driver.findElement(By.tagName("input")).click();
	
	driver.navigate().back();
	WebElement option2 = driver.findElement(By.name("toPort"));
	option2.click();
	Select select2 = new Select(option1);
	select2.selectByIndex(3);
	
	driver.findElement(By.tagName("input")).click();
	
	
	
	
	}
}