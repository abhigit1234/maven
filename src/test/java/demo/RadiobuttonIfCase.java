package demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadiobuttonIfCase {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");

		String gender = "1";
		List<WebElement> sex = driver.findElements(By.name("sex"));
		sex.size();
		for (WebElement ele : sex) {
		String value =	ele.getAttribute("value");
			if(value.equals(gender)) {
				ele.click();
			}
		}
		
	
	
	}
}
