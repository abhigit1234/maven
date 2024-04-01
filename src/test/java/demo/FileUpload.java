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
		driver.get("https://easyupload.io/");

		driver.findElement(By.xpath("//button[@class='dz-button']")).click();

		StringSelection ss = new StringSelection("C:\\Users\\tubby\\Desktop\\PERSONAL\\manualresume.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().getContents(ss);
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		
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