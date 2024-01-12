package demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import demo.TakeScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot2 {
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Date date = new Date();
		String datetime = date.toString().replace(" ", "-");
		System.out.println(datetime);

		File source = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File destfile = new File(".//screenshot//abhi.png");
		FileUtils.copyFile(source, destfile);
		System.out.println("screen saved succesfully");
		driver.quit();

	}

}