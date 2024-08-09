package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownloop {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		driver.manage().window().maximize();
		WebElement day = driver.findElement(By.id("day"));
		System.out.println(day.getSize());
		
		
		Select select = new Select(day);
		select.selectByValue("1");

		List<WebElement> dd = select.getOptions();
		System.out.println(dd.size());

		for (int i = 0; i <=dd.size(); i++) {
			String text = dd.get(i).getText();
			System.out.println(text);
			dd.get(i).click();
			Thread.sleep(2000);
		}

	}
}
