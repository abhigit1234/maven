package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class launch2 {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("https://www.amazon.com");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.findElement(By.partialLinkText("Privacy")).click();

	
	
	}
}