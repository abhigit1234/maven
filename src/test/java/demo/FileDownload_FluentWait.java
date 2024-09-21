package demo;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

public class FileDownload_FluentWait {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		

		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.download_default_content_settings.popups", 1);
		String path = System.getProperty("user.dir")+"\\downloads";
		prefs.put("download.default_directory", path);
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://examplefile.com/document/pdf/100-mb-pdf#google_vignette");
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/aside/div[1]/div[2]/a")).click();
		
		File f = new File(path);
		FluentWait<File> fw = new FluentWait<File>(f)
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(5))
				.withMessage("not downloaded");
		boolean b =	fw.until(x->x.canRead()&x.exists());
			if(b) {
				System.out.println("file downloaded");
			}else {
				System.err.println("file not downloded");
			}
		
		driver.close();
	
		
		}

}