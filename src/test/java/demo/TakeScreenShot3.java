package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot3 {

	public static void main(String[] args) throws IOException {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com");

//		 screenshot of full webpage  


//		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screen, new File(".//screenshot//abhi.png"));
//		driver.close();

//======================================================================================================
		
//		screenshot of section/portion  
		
//		WebElement ebay = driver.findElement(By.xpath("//*[@id=\"destinations_list1\"]"));
//		File screen = ebay.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screen, new File(".//screenshot//abhi.png"));
//		driver.close();

//======================================================================================================	
	
// screenshot of specific webelement(LOGO,text..)
	
		WebElement specificelement = driver.findElement(By.xpath("//*[@id=\"rtm_list4\"]/div/h2/a/div/span"));
		File screen = specificelement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(".//screenshot//abhi.png"));
		driver.close();

		
	}
}