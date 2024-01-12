package demo;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class webtablePagination {

	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");

		
		String page = driver.findElement(By.xpath("//ul[@class=\"pagination\"]")).getText().split("")[19];
						
		int text = Integer.parseInt(page);
		System.out.println("total pages are: "+text);
			
		
		
		for(int p=1;p<=text;p++) {
			WebElement actpage =	driver.findElement(By.xpath("//div[@id=\"dtBasicExample_paginate\"]//ul/li[contains(@class,'active')]"));
			System.out.println("active page: "+actpage.getText());
			actpage.click();				
				
			//String pages = Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li[not(contains(@id,'dtBasicExample'))]["+p+"]")).click();
			Thread.sleep(1000);
				
			
			int rows = driver.findElements(By.xpath("//table[@id=\"dtBasicExample\"]//tbody/tr")).size();
			System.out.println("no of rows "+rows);
		
			for (int r=1;r<=rows;r++) {
			String names =	driver.findElement(By.xpath("//table[@id=\"dtBasicExample\"]//tr["+r+"]/td[1]")).getText();
			String position =	driver.findElement(By.xpath("//table[@id=\"dtBasicExample\"]//tr["+r+"]/td[2]")).getText();
			
			System.out.println(names+" || "+position);

			}
			System.out.println();				
		}
		
		driver.close();
	}
}
