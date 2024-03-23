package demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class windowHandles {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.geeksforgeeks.org/handle-multiple-windows-in-selenium/");
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.linkText("Java Collection")));
	driver.findElement(By.xpath("//strong[contains(text(),'‘Recent Articles’ on Java Collection !')]")).click();
//method for titles 
	String parent = driver.getWindowHandle();
				Set<String> wh = 	driver.getWindowHandles();
				for (String child : wh) {
					if(driver.switchTo().window(child).getTitle().equals("")) {
						break;
					}else {
						driver.switchTo().window(parent);
					}
				}
	
	
	/*	method for switching 
	 * 
	 * 	String parentWindow = driver.getWindowHandle();
		
		
		Set<String> wh =  driver.getWindowHandles(); 
		for (String childWindow : wh) {
			if(!childWindow.equals(parentWindow)) {
				driver.switchTo().newWindow(WindowType.TAB);
				driver.manage().window().maximize();		
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver.close();
			}
		}
		
	*/
	}
}
