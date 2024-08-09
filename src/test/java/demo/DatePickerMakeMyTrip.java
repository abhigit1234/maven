package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerMakeMyTrip {
	public static void main(String[] args) throws Exception {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com");
		Thread.sleep(8000);

		String month = "June 2024";
		String day = "21";
	
		driver.findElement(By.xpath("//p[@data-cy=\"departureDate\"]")).click();
		Thread.sleep(1000);
		
		while(true) {
		String text	= driver.findElement(By.xpath("(//div[@class=\"DayPicker-Caption\"])[1]")).getText();
	System.out.println(text);
		if(text.equals(month)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
		}
		}
		WebElement date = driver.findElement(By.xpath("//div[@class=\"DayPicker-Month\"][1]//div[@class=\"DayPicker-Day\"]//div[contains(@class,\"dateInnerCell\")]/p[text()="+day+"]"));
		date.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
