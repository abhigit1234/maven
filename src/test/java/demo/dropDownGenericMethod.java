package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownGenericMethod {


	public static void main(String[] args) throws Exception {
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/signup");
	
	
	WebElement day = driver.findElement(By.id("day"));
	WebElement month =driver.findElement(By.id("month"));
	WebElement year = driver.findElement(By.id("year"));
	selectFromDropDown(day, "21");
	selectFromDropDown(month, "Jun");
	selectFromDropDown(year, "1989");
	
	}
	
	
	public static void selectFromDropDown(WebElement ele,String value) {
		Select s = new Select(ele);
		List<WebElement> list = 	s.getOptions();
		
		for(WebElement dList : list) {
			if(dList.getText().equals(value)) {
				dList.click();
			}
		}
	}

}