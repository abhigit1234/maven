package demo;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTimeOut_Time {
	public static void main(String[] args) throws IOException{ //===DEFAULT PAGELOAD TIMEOUT IN SELENIUM IS 300 SEC = 5MIN

		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		Instant startTime = Instant.now();

		System.out.println(startTime);

		driver.get("https://www.google.com");

		Instant endTime = Instant.now();

		System.out.println(endTime);
		
		Duration dur =  Duration.between(startTime, endTime);
	System.out.println(" total time is "+dur.toMillis());
		
		System.out.println(driver.getTitle());

		driver.quit();

	}

}
