package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webtable_select_particularValue {
	static WebDriver driver;

	@Test
	public void Login() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		
		List<WebElement> rowlist = driver.findElements(By.xpath("//table[@id=\"example\"]/tbody/tr/td[1]"));
		List<WebElement> collist = driver.findElements(By.xpath("//table[@id=\"example\"]/tbody/tr/td[1]/following-sibling::td[3]"));
		for (int i = 0; i < rowlist.size(); i++) {
			if(rowlist.get(i).getText().equalsIgnoreCase("Caesar Vance")) {
				System.out.println(collist.get(i).getText());
				
		}
			
		
			
			}
				
		}
			
	}	
	
	

// username  mngr527275
// password  UmamEmU