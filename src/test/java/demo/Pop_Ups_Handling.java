package demo;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pop_Ups_Handling {
	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeOptions opt = new ChromeOptions();
		HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

	// 0 = always ask || 1 = allow || 2 = Block
	
	//	contentSettings.put("notifications", 1);
		contentSettings.put("geolocation", 1); //geolocations
	//	contentSettings.put("media_stream", 1);	//mic/camera
		
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		opt.setExperimentalOption("prefs", prefs);
		
//		opt.addArguments("disable-notifications");//notification pop-ups 
//		opt.addArguments("disable-geolocations");//location pop-ups
//		opt.addArguments("disable-media-stream");//mictest/camera pop-ups
		
		
		
		
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.whatmylocation.com");
	//	driver.get("https://www.mictests.com");
		Thread.sleep(5000);
		driver.findElement(By.id("mic-launcher")).click();
	
		
	
	
	
	
	
	
	
	
	
	
	
	}
}