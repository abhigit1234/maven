package practice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseMethod extends BaseTest{

	@Parameters("url")
	@Test(groups = {"smoke","sanity"})
	public void Google(String url) throws InterruptedException {
		driver.get(url);
		extenttest.info("navigated to url");
		driver.findElement(By.name("q")).sendKeys("saibaba",Keys.ENTER);
		Thread.sleep(3000);
		extenttest.info("launched to entered text page successfully");
		String act =  driver.getTitle();
		String exp = "saibaba - Google Search";
		assertEquals(act, exp);
		extenttest.info("test passed for assertion");
	}
	@Parameters("url")
	@Test(groups = {"functional","regression","smoke"})
	public void OrangeHrm(String url) throws InterruptedException {
		driver.get(url);
		extenttest.info("navigated to url");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		extenttest.info("launched into home page");
		Thread.sleep(3000);
		String act = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).getText();
		String exp = "Paul Collingss";
		assertEquals(act, exp);
		extenttest.info("test failed due to assertion");
	}
}