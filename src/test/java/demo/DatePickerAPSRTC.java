package demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerAPSRTC {
	public static void main(String[] args) throws IOException, InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		String month = "May 2024";
		String date = "15";
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label/span")).click();
	while(true) {
		String text = driver.findElement(By.xpath("(//div[@class=\"DayPicker-Caption\"])[1]")).getText();
	
		if(text.equals(month)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
			
		}
		
	}
driver.findElement(By.xpath("(//div[@class=\"DayPicker-Body\"])[1]//div[contains(@aria-disabled,'false')]//p[text()='15']")).click();
	
	
	
	
	
	}
}
