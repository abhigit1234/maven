package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class naveenAuto {
	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.t-mobile.com/tablets?INTNAV=tNav:Devices:Tablets");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//legend[contains(text(),'Deals')]")).click();

		List<WebElement> list = driver.findElements(By.xpath("//mat-checkbox[contains(@id,'checkbox')]/label"));
		for (WebElement ele : list) {
			String text = ele.getText();

			System.out.println(text);
			if (text.equals("New") || text.equals("Special offer"))
				ele.click();
		}
	
	
	driver.findElement(By.xpath("//legend[contains(text(),'Brands')]")).click();
	List<WebElement> brands = driver.findElements(By.xpath("//mat-checkbox/label"));
	for (WebElement brand : brands) {
	String br = brand.getText();
		System.out.println(br);
		if(br.equals("Samsung")||br.equals("TCL")) {
			brand.click();
		}
	}
	}
}
