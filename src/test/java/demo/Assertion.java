package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Assertion {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/admin/");
		System.out.println(driver.getTitle());
		SoftAssert sf = new SoftAssert();
		
		
		String exp = "Administratio";
		String act = driver.getTitle();
		sf.assertEquals(act, exp);
		
		
		WebElement image =	driver.findElement(By.xpath("//img[@title='OpenCart']"));
		System.out.println(image.isDisplayed()); 
		

		WebElement loginbtn =	driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(loginbtn.isDisplayed()); 
		
		
		driver.close();
		sf.assertAll();
	}
}
