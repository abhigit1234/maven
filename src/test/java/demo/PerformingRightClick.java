package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;



public class PerformingRightClick {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();


		WebElement element =driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(element);
		
		WebElement  box = driver.findElement(By.xpath("//*[@id=\"swatch\"]"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.contextClick(box).perform();
	
		
		
		
	}}