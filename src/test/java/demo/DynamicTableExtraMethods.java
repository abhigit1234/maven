package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableExtraMethods {
	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");

		String beforeXpath = "//table[@id='countries']/tbody/tr[";
		String afterXpath = "]/td[2]";

		String xpath = "//table[@id='countries']/tbody/tr[2]/td[2]";
		for (int i = 2; i < xpath.length(); i++) {
			String names = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			System.out.println(names);
			if (names.equals("Chile")) {
				driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[" + i + "]/td[1]/input")).click();

			}
		}
		
		
		
		
		
		
	}

}
