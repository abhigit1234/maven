package demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SalesForceExcelReadText {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.salesforce.com/au/form/signup/freetrial-sales/?d=70130000000EndS");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement c = driver.findElement(By.xpath("//select[@name=\"CompanyCountry\"]"));
		Select c1 = new Select(c);
		c1.selectByVisibleText("Antigua And Barbuda");
	}
}