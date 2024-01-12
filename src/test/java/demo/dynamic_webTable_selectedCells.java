package demo;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamic_webTable_selectedCells {

	
	public static void main(String[] args) throws InterruptedException {
		
	

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
		Thread.sleep(4000);
		int statuscount = 0;

		List<WebElement> rowcnt2 = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]/div"));
	
System.out.println("row count is : "+rowcnt2.size());
		
			for (int i1 = 1; i1 < rowcnt2.size(); i1++) {

				String text2 = driver.findElement(By.xpath("//div[@class=\"oxd-table-body\"]/div[" + i1 + "]/div/div[3]")).getText();
			
				if (text2.equals("ESS")) {
					statuscount = statuscount + 1;

				
			}

		}
		
		System.out.println(" total ESS are : " + statuscount);
	}

}
