package demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxWithIfCondition {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		List<WebElement> check = driver.findElements(By.xpath("//label[@class=\"css-label_c t_c\"]"));
		for (WebElement ele : check) {
		if(ele.getText().equals("Flexible With Date")) {
			
		ele.click();
		
			Thread.sleep(1000);
		}}
		
		
		
		
		
		
		
		
		
		
		
}}