package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom_MultiNested {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		WebElement ele1 = 	driver.findElement(By.cssSelector("#shadow-root"));
		SearchContext s1 = (SearchContext)	((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", ele1);
		System.out.println(s1.findElement(By.cssSelector("#shadow-element")).getText());
	
		
//=====================================================================================	
		

		
		
		WebElement ele2	= s1.findElement(By.cssSelector("#inner-shadow-dom"));
		SearchContext s2 = (SearchContext)	((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", ele2);
		
		WebElement ele3 = 	s2.findElement(By.cssSelector("#nested-shadow-root"));		
		System.out.println(s2.findElement(By.cssSelector("#nested-shadow-element")).getText());

//=====================================================================================

		WebElement ele4 = 	s2.findElement(By.cssSelector("#nested-shadow-dom"));
		SearchContext s3 = (SearchContext)	((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", ele4);
		WebElement ele5 = 	s3.findElement(By.cssSelector("#multi-nested-shadow-root"));
		System.out.println(s3.findElement(By.cssSelector("#multi-nested-shadow-element")).getText());
	
		driver.close();
	
	
	}

}
