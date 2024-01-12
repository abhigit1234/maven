package demo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMethodEbay {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.ebay.com");
	driver.manage().window().maximize();
	
	WebElement dd = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
	System.out.println(driver.getTitle());
	
	System.out.println(dd.getSize());
	Select select = new Select(dd);
	select.selectByValue("0");
	
	List<WebElement> all = select.getOptions();
	all.size();
	for (int i=0;i<all.size();i++) {
				String text = all.get(i).getText();
				System.out.println(text);
				all.get(i).click();
				Thread.sleep(2000);
				
				
	}
	
 	}
}