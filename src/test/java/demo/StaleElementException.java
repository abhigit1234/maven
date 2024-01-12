package demo;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElementException {

	public static void main(String[] args) throws SQLException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://test.io/coverage/website-testing");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));

		WebElement c = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/section/div[2]/div[3]/div/div/div/div/div/div/a"));
			c.click();
	
			try {
				c.click();
			} catch (StaleElementReferenceException e) {
				c = driver.findElement(
						By.xpath("//*[@id=\"main\"]/div/div[1]/section/div[2]/div[3]/div/div/div/div/div/div/a"));
				c.click();
			}

	}
}