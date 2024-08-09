package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDownMakeMyTrip{
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com");
		Thread.sleep(4000);
		int i = 5;
		driver.findElement(By.xpath("//div[contains(@class,'flightTravllers ')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='appendBottom20']/ul[1]/li"));
		System.out.println(list.size());
		for (WebElement ele : list) {
			if(ele.getText().equals(String.valueOf(i))) {
				ele.click();
			}
		}
	}
}