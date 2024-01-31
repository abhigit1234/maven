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

		HashMap<String, Object> prefs = new HashMap<String, Object>();

		opt.addArguments("disable-notifications");
		opt.addArguments("disable-geolocations");
		opt.addArguments("disable-media-stream");

//		prefs.put("profile.default_content_setting_values.notifications", 1);
//		opt.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://optinmonster.com/types-of-popups-for-your-site/");

	}
}