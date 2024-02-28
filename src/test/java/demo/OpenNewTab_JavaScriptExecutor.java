package Demo;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab_JavaScriptExecutor{

	public static void main(String[] args)throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		
		((JavascriptExecutor)driver).executeScript("window.open('https://www.facebook.com')");
			Set<String> wh =  driver.getWindowHandles();
						Iterator<String> it = 	wh.iterator();		
						String parent = it.next();
						String child = it.next();
		driver.switchTo().window(child);
		driver.findElement(By.name("email")).sendKeys("koushikreddy");
		driver.switchTo().window(parent);
		driver.findElement(By.name("q")).sendKeys("hello");
		Thread.sleep(2000);
		
		driver.switchTo().window(child);
		driver.findElement(By.name("pass")).sendKeys("koushikreddy");
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("bye");
		
		
	}
	
}
