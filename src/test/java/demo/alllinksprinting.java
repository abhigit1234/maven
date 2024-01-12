package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;



public class alllinksprinting {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		List<WebElement> all = driver.findElements(By.tagName("a"));
		System.out.println("all tags are " + all.size());
		
		for(int i=0; i<all.size(); i++)
		{
		System.out.println("all links are "+all.get(i).getAttribute("href"));
		//System.out.println("all tagnames are "+all.get(i).getText());
		}
	}
}