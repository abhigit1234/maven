package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecuter {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
     //	WebElement ele = 	(WebElement) jse.executeScript("return document.getElementsByName(\"firstname\")[0]");
    //	ele.sendKeys("abhilashbabu");
	
	//	jse.executeScript("document.evaluate(\"//button[@name='websubmit']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.click()");
		
	//  jse.executeScript("document.getElementsByName('firstname')[0].value='abhialsh'");
	//  jse.executeScript("document.getElementsByName(\'websubmit\')[0].click();");
		
	//	WebElement fname = driver.findElement(By.name("firstname"));
	//  jse.executeScript("arguments[0].value='abhilashhhh'", fname);

	//	WebElement submit = driver.findElement(By.name("websubmit"));
	//	jse.executeScript("arguments[0].click()", submit);
	
	//	jse.executeScript("document.getElementsByName(\'firstname\')[0].style.border=\'5px red dashed\';");
	//	jse.executeScript("document.getElementsByName(\'firstname\')[0].style.background=\'yellow';");
	//	jse.executeScript("document.getElementsByName(\"firstname\")[0].setAttribute('style','border:10px pink dotted;background:brown');");
//	xpath = document.evaluate("//input[@name='firstname']",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;
// cssselector = document.querySelector('#u_0_b_xG');
		//window.scrollTo(0,300);
		//window.scrollBy(0,300);
	//scroll into view //document.evaluate("//*[@id='pageFooterChildren']/ul/li[16]/a",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.scrollIntoView();
		
	}
}