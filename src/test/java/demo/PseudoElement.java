package demo;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElement {

	public static void main(String args[]) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://play1.automationcamp.ir/advanced.html");
		
		String s = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(document.querySelector('.star-rating'),'::after').getPropertyValue('content')").toString();
		System.out.println(s); 
		
		String s1 = s.replaceAll("\"", "");
		System.out.println(s1);
		driver.findElement(By.id("txt_rating")).sendKeys(s1);
		driver.findElement(By.id("check_rating")).click();
		System.out.println(driver.findElement(By.id("validate_rating")).getText());
		//driver.close();
	
	
		
	}
}
