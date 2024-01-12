package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POM_FirstMethod_1{

	WebDriver driver;
	By fname = By.name("firstname");
	By lname = By.name("lastname");
	By email = By.name("reg_email__");
	By pass  = By.name("reg_passwd__");
	By date  = By.id("day");
	By mon  = By.id("month");
	By yr  = By.id("year");
	By sexx = By.name("sex");
	
	POM_FirstMethod_1(WebDriver d){
		driver =d;
	
	}
	
	public void fname(String f) {
		driver.findElement(fname).sendKeys(f);
	}
	

	public void lname(String l) {
		driver.findElement(lname).sendKeys(l);
	}

	public void email(String e) {
		driver.findElement(email).sendKeys(e);
	}
	public void setpassword(String p) {
		driver.findElement(pass).sendKeys(p);
	}

	public void setday() {
	WebElement day1 =	driver.findElement(date);
		Select s1 = new Select(day1);
		s1.selectByIndex(20);
	}
	

	public void setmonth() {
	WebElement mon1 =	driver.findElement(mon);
	Select s2 = new Select(mon1);
	s2.selectByIndex(5);
	
	}

	public void setyear() {
		WebElement yr1 =	driver.findElement(yr);
		Select s3 = new Select(yr1);
		s3.selectByValue("1989");
		}
	
	public void radio() {
		List<WebElement> list = driver.findElements(sexx);
		for (WebElement ele : list) {
			if(ele.getAttribute("value").equals("2")) {
				ele.click();
			}
		}
	
}}