package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHower {
public static void main(String[] args) throws InterruptedException {

	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.ebay.com");
	driver.manage().window().maximize();
	WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[7]/a"));
	
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[7]/div[2]/div[1]/nav[1]/ul/li[1]/a")).click();
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[@id=\"s0-16-12_2-0-1[0]-0-0\"]/ul/li[4]/a")).click();
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	
	
	
	





}
}
