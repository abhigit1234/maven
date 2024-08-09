package demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownIfCondition {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		WebElement day = driver.findElement(By.id("day"));
			String date = "2";
			
		Select select = new Select(day);
		List<WebElement> options = select.getOptions();
		for(WebElement ele:options) {
			if(ele.getText().equals(date)) {
				ele.click();
			}
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}