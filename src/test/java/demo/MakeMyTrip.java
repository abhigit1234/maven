
package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

		List<WebElement> ele = driver.findElements(By.xpath("//ul[contains(@class,'darkGreyText')]/li"));
		for (WebElement e : ele) {
			if (e.getText().equals("One Way")){
				e.click();
			}

		}
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("London");
		Thread.sleep(1000);

		List<WebElement> fromList = driver.findElements(By.xpath("//ul[@role='listbox']/li/div/div/div/div/div/p"));

		for (WebElement list1 : fromList) {

			try {
				if (list1.getText().equals("Oxford, United Kingdom")) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click()", list1);
				}

			} catch (Exception e) {

			}
		}
		WebElement stale = driver.findElement(By.xpath("//label[@for='toCity']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", stale);

		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("India");
		Thread.sleep(1000);
		List<WebElement> toList = driver.findElements(By.xpath("//ul[@role='listbox']/li/div/div/div/div/div/p"));
		try {

			for (WebElement list2 : toList) {

				if (list2.getText().equals("Hyderabad, India")) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click()", list2);
				}

			}
		} catch (Exception e) {

		}

		String month = "April 2025";
		String date = "21";

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='departure']")));

		while (true) {
			String text = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
			System.out.println(text);
			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(
				"(//div[@class='DayPicker-Body'])[1]/div/div[@aria-selected='false']/div/p[text()='" + String.valueOf(date) + "']")));

		String returnMonth = "July2025";
		String returnDate = "10";

		driver.findElement(By.xpath("//div[@data-cy='returnArea']")).click();

		while (true) {
			String text = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
			System.out.println(text);
			if (text.equals(returnMonth)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("(//div[@class='DayPicker-Body'])[1]/div/div[@aria-selected='false']/div/p[text()='" + returnDate + "']")));
	
		
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
	List<WebElement> noOfAdult =	driver.findElements(By.xpath("(//div[contains(@class,'gbTravellers')]/div/ul)[1]/li"));
		for (WebElement travellers : noOfAdult) {
			if(travellers.getText().equals("6")) {
				travellers.click();
			}
		}
		
		List<WebElement> noOfChild =	driver.findElements(By.xpath("//div[contains(@class,'childCounter')]/ul/li"));
		for (WebElement travellers : noOfChild) {
			if(travellers.getText().equals("1")) {
				travellers.click();
			}
		}	
		
		List<WebElement> noOfInfants =	driver.findElements(By.xpath("//div[contains(@class,'infantCounter')]/ul/li"));
		for (WebElement travellers : noOfInfants) {
			if(travellers.getText().equals("1")) {
				travellers.click();
			}
		}	
		List<WebElement> economy =	driver.findElements(By.xpath("(//ul[contains(@class,'darkText')])[4]/li"));
		for (WebElement travellers : economy) {
			System.out.println(travellers.getText());
			if(travellers.getText().contains("Business")) {
				travellers.click();
			}
		}	
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",	driver.findElement(By.xpath("//button[text()='APPLY']")));
		
		List<WebElement> fare =	driver.findElements(By.xpath("//div[@class='fareCardItem ']/div/div"));
		for (WebElement f : fare) {
			System.out.println(f.getText());
			if(f.getText().contains("Student")) {
				f.click();
			}
		}
		
		driver.findElement(By.xpath("//p[@data-cy='submit']/a")).click();
		String act = driver.findElement(By.id("specialFareEorroMessage")).getText();
		String exp = "Only adult passengers can avail of Student fares. You may continue to book a regular fare or de-select all child/infant passengers to book the Student fare.";
		
		
		assertEquals(act, exp);
		driver.close();
	
	}

}
