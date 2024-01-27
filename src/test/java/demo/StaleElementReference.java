package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReference {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.automationtesting.in/Register.html");

		WebElement ele = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		ele.sendKeys("hello");
		driver.navigate().refresh();
		try {
			ele = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
			ele.sendKeys("hello");
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getStackTrace());
		}


	}
}
