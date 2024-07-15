package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Shadow_DOM {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		WebElement root1 = driver.findElement(By.cssSelector("#userName"));
		SearchContext s1 = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",root1);
		s1.findElement(By.cssSelector("#kils")).sendKeys("abhilash");
		
		driver.switchTo().frame(s1.findElement(By.cssSelector("#pact1")));
		driver.findElement(By.cssSelector("#glaf")).sendKeys("abhilash");
		
		driver.switchTo().parentFrame();
		
		WebElement root2 = s1.findElement(By.cssSelector("#app2"));
		SearchContext s2 = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",root2);
		s2.findElement(By.cssSelector("#pizza")).sendKeys("abhilash");
		
		s1.findElement(By.cssSelector("#concepts")).click();
		Actions a = new Actions(driver);
		
		a.keyDown(Keys.TAB).perform();
		a.sendKeys("abhilash").perform();
		
		driver.findElement(By.cssSelector("#userPass")).click();
		a.keyDown(Keys.TAB).perform();
		a.sendKeys("abhilash").perform();
		
	}
}