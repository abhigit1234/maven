package demo;

//----------//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autosuggestionMakeMyTrip {
	public static void main(String[] args) throws InterruptedException {
		
	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com");
		Thread.sleep(5000);
	
		driver.findElement(By.xpath("//label[@for=\"fromCity\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("europe");
	Thread.sleep(2000);
	 List<WebElement> list = driver.findElements(By.xpath("//div[@role='listbox']/div/ul/li/div/div/p[1]"));	
		System.out.println(list.size());
	
	for (WebElement ele : list) {
		
		System.out.println(ele.getText());
			if(ele.getText().equals("Copenhagen, Denmark")) {
			
				ele.click();
			}
	}
	
		}
		
		
		
	}

