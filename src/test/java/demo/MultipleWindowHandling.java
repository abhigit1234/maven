package demo;

import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class MultipleWindowHandling {
	public static void main(String[] args) {
		
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"1666820637520_9ph\"]/div[1]/article/div[2]/div/pbc-button[1]")).click();
		Set<String> wh = driver.getWindowHandles();
		System.out.println(wh);
		
		Iterator<String> iterator = wh.iterator();
		String parent  = iterator.next();
		System.out.println(parent);
		
		String child = iterator.next();
		System.out.println(child);
		
		driver.switchTo().window(child);
		driver.findElement(By.name("UserFirstName")).sendKeys("abhilash babu");
		driver.findElement(By.name("UserLastName")).sendKeys("durgumahanth");
		
		driver.switchTo().window(parent);
		
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
		
		
	}}
		
