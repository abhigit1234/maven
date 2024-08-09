package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragdropByLocation {

	public static void main(String[] args) throws Exception {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
	WebElement ele = driver.findElement(By.xpath("//span[contains(@class,\"ui-state-default\")][1]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(ele, 140, 0).perform();
	}
	}


