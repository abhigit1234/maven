package demo;


import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class webTablePagination_1 {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");

		int pagesize = driver.findElements(By.xpath("//div[@id=\"example_paginate\"]//span//a")).size();
		System.out.println("Total pages: "+pagesize);

		List<String> names = new ArrayList();
		for (int i = 1; i <=pagesize; i++) {
			driver.findElement(By.xpath("//div[@id=\"example_paginate\"]//span//a["+i+"]")).click();
			//Thread.sleep(1000);
			
			List<WebElement> row = driver.findElements(By.xpath("//table[@id=\"example\"]//tbody//tr/td[1]"));
			for (int j = 0; j < row.size(); j++) {
			String rownames =	row.get(j).getText();
			names.add(rownames);	
			
			}
			
		}
		for (String name : names) {
			System.out.println(name);
		}
		int totalnames = names.size();
		System.out.println("Total number of names "+totalnames);
		
		String diaplaynamecount = driver.findElement(By.xpath("//div[@id=\"example_info\"]")).getText().split(" ")[5];
		System.out.println("displayed names count : "+diaplaynamecount);
	
		assertEquals(diaplaynamecount, Integer.toString(totalnames));
	}

}
