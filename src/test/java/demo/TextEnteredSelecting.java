package demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextEnteredSelecting {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("abhilash");
		System.out.println(firstname.getAttribute("value"));
		

	
	
	
	
	
	
	
	
	
	}
}