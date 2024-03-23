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

	public static void main(String[] args)throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
/*
// first box
		WebElement root1 =  driver.findElement(By.cssSelector("#userName"));		
		SearchContext shadow1 = (SearchContext)	((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root1); 
		shadow1.findElement(By.cssSelector("#kils")).sendKeys("watermelon");

//second box
		WebElement frame =   shadow1.findElement(By.cssSelector("#pact1"));
		driver.switchTo().frame(frame);
		driver.findElement(By.cssSelector("#glaf")).sendKeys("grapes");
*/		

/*
//third box
		WebElement root2 =  driver.findElement(By.cssSelector("#userName"));		
		SearchContext shadow2 = (SearchContext)	((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root2); 
		
		WebElement root3 =  shadow2.findElement(By.cssSelector("#app2"));		
		SearchContext shadow3 = (SearchContext)	((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root3); 
		shadow3.findElement(By.cssSelector("#pizza")).sendKeys("pineapple");
*/		

/*		
//fourth box		
		
		WebElement root4 =  driver.findElement(By.cssSelector("#userName"));		
		SearchContext shadow4 = (SearchContext)	((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root4); 
	
		shadow4.findElement(By.cssSelector("#concepts")).click();
		Actions a = new Actions(driver);
		a.keyDown(Keys.TAB).perform();
		a.sendKeys("CusturdApple").perform();
*/	

	
//fifthbox -- shadow closed
//		If shadow dom is closed then we must move to top nearby element and click
		//	and move our tab to box by using actions class and send keys in actions class	
			
		
		driver.findElement(By.cssSelector("#userPass")).click();
		Actions a = new Actions(driver);
		a.keyDown(Keys.TAB).perform();
		a.sendKeys("Faluda").perform();
	
	}

}
