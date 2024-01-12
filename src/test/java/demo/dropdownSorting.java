package demo;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownSorting {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.findElement(By.id("menu1")).click();
		List<WebElement> list =  driver.findElements(By.xpath("//ul[@aria-labelledby=\"menu1\"]/li"));
		List<String> originalList = new ArrayList<String>();  
		for(WebElement e : list) {
			String text = e.getText();
			originalList.add(text);
		}
		List<String> temp = new ArrayList<String>();
		temp=originalList;
		System.out.println("before sorting "+temp);
		Collections.sort(temp);// ascending			
		//Collections.sort(temp,Collections.reverseOrder()); descending
		System.out.println("after sorting "+temp);
		
	}

}