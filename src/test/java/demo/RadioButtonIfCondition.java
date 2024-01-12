package demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class RadioButtonIfCondition {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
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