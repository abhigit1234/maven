package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framealerthandling {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		WebElement web = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(web);
		
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
		
		driver.switchTo().alert().sendKeys("abhilash babu");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
		
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		
				
		
		
		
		
	}
}