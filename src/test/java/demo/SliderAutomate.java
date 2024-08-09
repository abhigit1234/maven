package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SliderAutomate {
public static void main(String[] args) throws InterruptedException {
	
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://jqueryui.com/slider/#colorpicker");
	
	driver.manage().window().maximize();
	
	
	WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
	driver.switchTo().frame(element);
	WebElement drag = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
	Actions action = new Actions(driver);
	action.dragAndDropBy(drag, 50, 0).perform();			
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}}
