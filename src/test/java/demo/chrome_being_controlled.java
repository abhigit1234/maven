package demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class chrome_being_controlled {
	WebDriver driver;

	@Test
	public void test1() {
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver(opt);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
	}

	@Test
	public void test2() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		assertEquals(true, false);
	}

}
