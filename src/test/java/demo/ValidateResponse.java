package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateResponse {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/admin");
		assertEquals(driver.getPageSource().contains("404")|driver.getTitle().contains("404"),true);
		driver.close();
		
	
	}
}