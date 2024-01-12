package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POM_SecMethod_1 {

	
	WebDriver driver;
	
	@FindBy(name="firstname") WebElement fname;
	@FindBy(name="lastname") WebElement lname;
	@FindBy(name="reg_email__") WebElement email;
	@FindBy(name="reg_passwd__") WebElement password;
	@FindBy(id="day") WebElement date;
	@FindBy(id="month") WebElement month;
	@FindBy(id="year") WebElement year;
	@FindBy(name="sex") List<WebElement> radio;
	
	POM_SecMethod_1(WebDriver d){
	driver =d;
	PageFactory.initElements(driver, this);
	}
	
	public void setfname(String f) {
		fname.sendKeys(f);
	}

	public void setlname(String l) {
		lname.sendKeys(l);
	}
	public void setemail(String e) {
		email.sendKeys(e);
	}
	public void setpassword(String p) {
		password.sendKeys(p);
	}
	public void setdate() {
		Select s1 = new Select(date);
		s1.selectByIndex(20);
	}
	public void setmonth() {
		Select s2 = new Select(month);
		s2.selectByValue("6");
	}

	public void setyear() {
		Select s3 = new Select(year);
		s3.selectByVisibleText("1989");
	}

	public void setradio() {
		for (WebElement ele : radio) {
			if(ele.getAttribute("value").equals("-1")) {
				ele.click();
			}
		}
	}
	
	
	
	
	
}