package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Nested {
	public static void main(String[] args) throws Exception{
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/Frames.html");
	driver.findElement(By.xpath("(//div[@class='tabpane']/ul/li/a)[2]")).click();
		
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hi");
	
	
	
	
	}
}