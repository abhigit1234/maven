package demo;



import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadChromeOptions {
	public static void main(String[] args) throws Exception{
		
		ChromeOptions opt = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap();
		prefs.put("profile.default_content_settings.popups", 0);

		String path = System.getProperty("user.dir")+".\\downloads";
	
		prefs.put("download.default_directory",path);
		opt.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://downloadtestfile.com/5mb-test-file-download/");
		driver.findElement(By.xpath("(//div[contains(text(),'Downloa')])[1]")).click();
		Thread.sleep(5000);
		File f = new File(path);
		if(f.exists()) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	
		
	
	
	
	
	}
}
