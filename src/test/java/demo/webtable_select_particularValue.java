package demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable_select_particularValue {
	static WebDriver driver;

	@Test
	public void Login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
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