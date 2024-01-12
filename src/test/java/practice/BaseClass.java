package practice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\\\"SW\\\"]/div[1]/div[2]/div[2]/div/section/span")WebElement adsclose;
	@FindBy(xpath = "//label[@for=\"fromCity\"]")WebElement fromLabel;
	@FindBy(xpath = "//input[@placeholder=\"From\"]")WebElement fromBox;
	@FindBy(xpath = "//div[@role=\"listbox\"]//ul//li//div//div//p[1]")List<WebElement> autosuggest;
	
	
	
	BaseClass(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickads() {
		adsclose.click();
	}
	public void clickFrom() {
		fromLabel.click();
	}
	public void clickBox() {
		fromBox.sendKeys("singapore");
	}
	public void iterate() throws InterruptedException {
	List<WebElement> list = 	autosuggest;
	System.out.println(list.size());
	for (WebElement ele : list) {
		System.out.println(ele.getText());
		
		if(ele.getText().equals("Sinop, Brazil")) {
			ele.click();
		}
	}
	
	}
public void close() {
	driver.close();	
	}
}	