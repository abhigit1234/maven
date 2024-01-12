package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headlessBrowser {

	public static void main(String[] args) {

		ChromeOptions opt = new ChromeOptions();
	//	opt.addArguments("--headless=new");
		opt.addArguments("--headless");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("http://localhost/opencart/upload/index.php?route=account/register&language=en-gb");
		System.out.println(driver.getTitle());
		
	}
}
