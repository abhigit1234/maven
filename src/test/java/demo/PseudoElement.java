package demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElement {

	public static void main(String args[]) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:90/opencart/upload/index.php?route=account/register&language=en-gb");

		// =====single star

		/*
		 * System.out.println(((JavascriptExecutor) driver).executeScript(
		 * "return window.getComputedStyle(arguments[0],'::Before').getPropertyValue('content')"
		 * ,
		 * driver.findElement(By.xpath("//label[@for='input-firstname']"))).toString());
		 */
//===================================================================================		
		// =====multiple stars

		/*
		 * List<WebElement> list =
		 * driver.findElements(By.xpath("//form[@id='form-register']//label")); for
		 * (WebElement e : list) { System.out.println(((JavascriptExecutor)
		 * driver).executeScript(
		 * "return window.getComputedStyle(arguments[0],'::Before').getPropertyValue('content')"
		 * , e)); }
		 */
		driver.close();

	
		
	}
}
