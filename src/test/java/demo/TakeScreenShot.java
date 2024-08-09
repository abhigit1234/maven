package demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {
	public static void main(String[] args) throws IOException, InterruptedException  {


		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com");
		Thread.sleep(2000);
		
		Date date = new Date();
	String currentdate =	date.toString().replace(" ", " ").replace(":", " ");
		System.out.println(currentdate);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
	WebElement section =	driver.findElement(By.xpath("//*[@id=\"destinations_list1\"]/ul/li[2]/a/div[1]/div/div"));
	File source =	section.getScreenshotAs(OutputType.FILE);
			File target = new File(".\\Screenshot\\"+currentdate+".png");
		FileUtils.copyFile(source, target);
		

		
		driver.close();
		
		
		
		
		
		
		
	}
}