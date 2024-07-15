package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWinUsingTabs {
static WebDriver driver;
	public static void main(String[] args) throws Exception{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
	
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.facebook.com");
	
		Set<String> s = 	driver.getWindowHandles();
		for (String s1 : s) {
		System.out.println(driver.switchTo().window(s1).getTitle());
		}
		System.out.println();
		
		s.forEach(x->System.out.println(driver.switchTo().window(x).getTitle()));
		
		
		
		
		
	}
	
	
}