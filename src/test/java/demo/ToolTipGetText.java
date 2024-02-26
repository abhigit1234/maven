package Utilities;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipGetText {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//p[contains(@class,'ewETUe')]")).click();		
		WebElement e = driver.findElement(By.xpath("//li/span[text()='senior citizen']"));
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		System.out.println(driver.findElement(By.xpath("(//span[@class='fswTooltip__text'])[2]")).getText());
		
		driver.close();
	}}
