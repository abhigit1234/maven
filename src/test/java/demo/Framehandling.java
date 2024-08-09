package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framehandling {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();

		///////////////////////////          framen by index       ///////////////////////////////////////////////////
//		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
//		driver.manage().window().maximize();
//		driver.switchTo().frame(1);
//		driver.findElement(By.xpath("/html/body/button")).click();

		
		////////////////////////////           frame by string     ///////////////////////////////////////////////////////		
		
//		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
//		driver.manage().window().maximize();
//		driver.switchTo().frame("iframeResult");
//		driver.findElement(By.xpath("/html/body/button")).click();
		
		////////////////////////////////         frame by webelement    ///////////////////////////////
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		WebElement web = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(web);
		driver.findElement(By.xpath("/html/body/button")).click();
		
		
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame();
		
		System.out.println(driver.getTitle());

		
		
		
		
		
	}
}