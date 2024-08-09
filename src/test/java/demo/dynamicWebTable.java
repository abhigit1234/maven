package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicWebTable {
public static void main(String[] args) throws InterruptedException {
	


		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
	Thread.sleep(4000);
	List<WebElement> rowcnt = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]/div"));
		System.out.println("rows : "+rowcnt.size());

		List<WebElement> cellcnt = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]/div[1]/div/div"));
		System.out.println("coloumns : "+cellcnt.size());
		
		for (int i = 1; i < rowcnt.size(); i++) {
			for (int j = 1; j < cellcnt.size(); j++) {
				System.out.print(driver.findElement(By.xpath("//div[@class=\"oxd-table-body\"]/div["+i+"]/div/div["+j+"]")).getText()+"||");
			}
	
			System.out.println();
			}
	
	
	}
}
