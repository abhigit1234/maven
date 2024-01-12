package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='HTML, CSS']")).click();
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]/li[not(contains(@class,'multiselect-group'))]"));
		for (WebElement option : options) {
			String text = option.getText();
		WebElement k = option.findElement(By.tagName("input"));
			if(text.equals("Java"))
				k.click();
			if(text.equals("HTML"))
				k.click();

			if(text.equals("MySQL"))
				k.click();
			

		}
		Thread.sleep(2000);
		driver.close();
	}
}
