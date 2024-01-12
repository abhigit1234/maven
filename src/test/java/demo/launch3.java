package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launch3 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/signup");
		WebElement day = driver.findElement(By.id("day"));
		day.click();
		Select d1 = new Select(day);
		d1.selectByIndex(1);
		System.out.println(day.getAttribute("value"));

		List<WebElement> dd = d1.getAllSelectedOptions();
		System.out.println(dd.size());

		for( int i=0; i< dd.size(); i++)
		{
			String text = dd.get(i).getText();
			System.out.println(text);
			dd.get(i);
			Thread.sleep(2000);
		}
		
	}
}
