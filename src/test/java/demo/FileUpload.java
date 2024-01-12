package demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FileUpload {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
	

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.foundit.in/");
//=======================================================================================//
		// if html page has (type=file) attribute we can use this method
		//	driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();
		//	driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\tubby\\Desktop\\PERSONAL\\Resume.doc");
//===========================================================================================//		
		 driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();
		 WebElement ele = driver.findElement(By.id("file-upload"));
			/*
			 * JavascriptExecutor jse = (JavascriptExecutor)driver;
			 * jse.executeScript("arguments[0].click()", ele);
			 */
		 Actions a = new Actions(driver);
		 a.click(ele).perform();
		 
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\tubby\\Desktop\\PERSONAL\\manualresume.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().getContents(ss);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	
		driver.findElement(By.id("pop_upload")).click();	
	
	
	
	}
}