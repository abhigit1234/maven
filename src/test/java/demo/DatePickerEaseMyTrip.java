package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DatePickerEaseMyTrip {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.easemytrip.com/");
		

		String month = "JUN 2027";
		String day = "10";

		driver.findElement(By.xpath("(//div[@class=\"fss_flex depdate_colm sechver deplbl\"])[1]")).click();
		Thread.sleep(1000);

		while (true) {
			String text = driver.findElement(By.xpath("//div[@class=\"month\"]")).getText();
System.out.println(text);
			if (text.equals(month)) {
				break;
			} 
			else {
				driver.findElement(By.xpath("//img[@onclick=\"NextPrevClick('nxtMnt')\"]")).click();
			}
		}
		List<WebElement> days = driver.findElements(By.xpath("(//li[text()="+day+"])[1]"));

		for (WebElement ele : days) {
			String text = ele.getText();
			System.out.println(text);
			if(text.equalsIgnoreCase(day)) {
				ele.click();
				
			}
			
		}

		driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/div/form/div[1]/div[4]/button/span")).click();
	}
}
