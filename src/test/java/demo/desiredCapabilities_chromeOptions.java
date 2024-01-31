package demo;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class desiredCapabilities_chromeOptions {
	public static void main(String[] args) {

		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
	//	opt.addArguments("incognito");
		opt.addArguments("disable-infobars");
	//	opt.addArguments("headless");
		opt.setAcceptInsecureCerts(true);
		opt.addArguments("disable-notifications");		
		
		
		
		WebDriver driver = new ChromeDriver(opt);
		//InsecureCerts 
		//driver.get("https://www.cacert.com");
		
		driver.get("https://optinmonster.com/types-of-popups-for-your-site/");
		System.out.println(driver.getTitle());
	
	}

}