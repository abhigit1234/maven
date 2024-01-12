package demo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SliderAutomate {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://jqueryui.com/slider/#colorpicker");
	
	driver.manage().window().maximize();
	
	
	WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
	driver.switchTo().frame(element);
	WebElement drag = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
	Actions action = new Actions(driver);
	action.dragAndDropBy(drag, 50, 0).perform();			
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}}
