package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class launch2 {
public static void main(String[] args) throws InterruptedException {
	
		
	ChromeDriver driver= new ChromeDriver();
	driver.get("https://www.amazon.com");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.findElement(By.partialLinkText("Privacy")).click();

	
	
	}
}