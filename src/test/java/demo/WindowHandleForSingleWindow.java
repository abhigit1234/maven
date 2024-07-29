package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleForSingleWindow {
	static WebDriver driver;
	public static void main(String[] args)throws Exception {
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.foundit.in/");
	driver.findElement(By.xpath("/html/body/section/div[3]/div/div[1]/div/a[1]/div/div[4]")).click();
	Set<String> wh =	driver.getWindowHandles();
	Iterator<String> it =	wh.iterator();
	String parent = it.next();
	String child = it.next();
	
	if(!child.equals(parent)) {
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//*[@id=\"seekerHeader\"]/div/div[4]/div/div/button[2]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"seekerHeader\"]/div/div[4]/div/div/button[1]")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
	}
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.close();
	
	
	}
}