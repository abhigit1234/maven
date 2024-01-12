package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestion_gobibo {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[contains(@class,'sc-12foipm-16')])[1]")).click();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("i");
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.xpath("//li[@role=\"presentation\"]/div/div/div/p[2]"));
	System.out.println(list.size());
		for (WebElement ele : list) {

			System.out.println(ele.getText());
			if(ele.getText().trim().contains("Tulihal International Airport")) {
				Thread.sleep(2000);
				ele.click();			
				}
		}

	}
}
