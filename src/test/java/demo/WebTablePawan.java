package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTablePawan {// goibibo site lo ::before ::after
	public static List<String> names;

	public static void main(String args[]) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/admin/");

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
		driver.findElement(By.xpath("(//ul[@id='collapse-5']/li/a)[1]")).click();

		String disText = driver.findElement(By.xpath("(//div[contains(@class,'text-end')])[2]")).getText();
		System.out.println(disText);
		int pageNum = Integer.valueOf(disText.substring(disText.indexOf("(") + 1, disText.indexOf("Pages") - 1));
		System.out.println(pageNum);
		List<WebElement> rowNames = null;
		List<String> names=null;
		for (int i = 1; i <=pageNum; i++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//li[@class='page-item active']/span")));
			rowNames = driver.findElements(By.xpath("//div[@id='customer']//table/tbody/tr/td[2]"));
			names = new ArrayList<String>();
			try {
				for (WebElement name : rowNames) {
					names.add(name.getText());
				}
				for (String name : names) {
					System.out.println(name);
				}
			} catch (Exception e) {

			}

			
			Actions a = new Actions(driver);
			a.click(driver.findElement(By.xpath("//li[@class='page-item']/a[text()='" + Integer.toString(i + 1) + "']"))).perform();
			Thread.sleep(500);
		}
		driver.close();
	}
}
