package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/signup");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("firstname")).sendKeys("abhilash");
		driver.findElement(By.name("lastname")).sendKeys("babu");
		driver.findElement(By.name("reg_email__")).sendKeys("9985400503");
	driver.findElement(By.id("password_step_input")).sendKeys("123456789");
	
		
		
		WebElement dd = driver.findElement(By.id("day"));
		dd.click();
		Select select = new Select(dd);
		select.selectByIndex(20);
		
		WebElement dd1 = driver.findElement(By.id("month"));
		dd1.click();
		Select select1 = new Select(dd1);
		select1.selectByValue("6");
		
		WebElement dd2 = driver.findElement(By.xpath("//select[@aria-label='Year']"));
		dd2.click();
		Select select2 = new Select(dd2);
		select2.selectByIndex(34);

		driver.findElement(By.xpath("//label[text()=\"Male\"]")).click();
		
	driver.findElement(By.name("websubmit")).click();	
		
	}	
}
