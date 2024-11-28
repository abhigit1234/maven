package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Webtable_FullPages_ParticularValue {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:90/opencart/upload/admin/");

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
		List<WebElement> colNames = null;
		List<String> names = null;
		for (int i = 1; i <= pageNum; i++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//li[@class='page-item active']/span")));
			rowNames = driver.findElements(By.xpath("//div[@id='customer']//table/tbody/tr/td[3]"));
			colNames = driver.findElements(By.xpath("//div[@id='customer']//table/tbody/tr/td[3]/preceding-sibling::td[1]"));
			names = new ArrayList<String>();

			for (WebElement name : rowNames) {
				names.add(name.getText());
			}
//			for (String name : names) {
//				System.out.println(name);
//			}

			for(int j=1;j<rowNames.size();j++) {
				if(rowNames.get(j).getText().contains("vrDHGpLTlM@gmail.com")){
				System.out.println(colNames.get(j).getText());
				}
			}			
			
			Actions a = new Actions(driver);
			a.click(driver
					.findElement(By.xpath("//li[@class='page-item']/a[text()='" + Integer.toString(i + 1) + "']")))
					.perform();
			Thread.sleep(200);
		}
		driver.close();

	}

}