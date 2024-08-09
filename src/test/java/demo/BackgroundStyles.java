package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackgroundStyles {
	public static void main(String[] args) throws IOException, InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement fname = driver.findElement(By.name("firstname"));
		
		jse.executeScript("arguments[0].value='abhilash'",fname);
// border		jse.executeScript("document.getElementsByName(\"firstname\")[0].style.border=\"5px red dotted\";");
//background		jse.executeScript("document.getElementsByName(\"firstname\")[0].style.background=\"pink\";");
			jse.executeScript("document.getElementsByName(\"firstname\")[0].setAttribute('style','border:6px pink solid;background:yellow');");
	
	
	
	
	
	
	
	
	
	
	}
}