package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerIRCTC {
	public static void main(String[] args) throws Exception  {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	String month = "October2023";
	String day = "25";
	
	driver.get("https://www.irctc.co.in/nget/train-search");

	driver.findElement(By.xpath("//input[@class=\"ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted\"]//parent::span")).click();
	Thread.sleep(2000);

	
	
	while(true) {
		String text = driver.findElement(By.xpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/div[1]")).getText();
		
		if(text.equals(month)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/a[2]/span[1]")).click();
			
		}
	
	}
		
		driver.findElement(By.xpath("//tbody/tr/td/a[contains(text(),"+day+")]")).click();
		
		
		
		
		
	
}}