package demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonIfCondition {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		String sex = "2";
		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		List<WebElement> gender = driver.findElements(By.name("sex"));	
		
		int list = gender.size();
		
		for (WebElement ele : gender) {
		String at =	ele.getAttribute("value");
			if(at.equals(sex)) {
				ele.click();
			}
		}
			
		
		
			
			
		
		
		
		
		
		
		

	}
}