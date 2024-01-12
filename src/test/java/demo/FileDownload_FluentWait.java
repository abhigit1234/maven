package demo;

import java.awt.AWTException;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FileDownload_FluentWait {

	public static void main(String[] args) throws Exception {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://downloadtestfile.com/5mb-test-file-download/");
		driver.findElement(By.xpath("(//div[contains(text(),'Downloa')])[1]")).click();
		String downloadPath = "C:\\Users\\tubby\\Desktop";
		
		
		File file = new File(downloadPath);
		FluentWait<File> wait = new FluentWait<File>(file)
				.withTimeout(Duration.ofMinutes(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class)
				.withMessage("file is not downloaded");
boolean isdownloaded = wait.until(f->f.exists() && f.canRead());
				if(isdownloaded) {
					System.out.println("file downloaded completed");
				}else {
					System.out.println("file not completely downloaded");
				}
		
	}

}