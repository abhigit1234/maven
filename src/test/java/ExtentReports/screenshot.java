package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {

	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
		extent.attachReporter(spark);

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		Thread.sleep(2000);
	
		String base64 = capture();
		String path = screenshot("google.png");

		
		extent.createTest("Test1")
		.addScreenCaptureFromBase64String(base64);
		
		extent.createTest("Test2")
		.addScreenCaptureFromBase64String(base64, "Google home page");
		
		extent.createTest("Test 3")
		.addScreenCaptureFromPath(path);
		
		extent.createTest("Test 4")
		.addScreenCaptureFromPath(path, "google home page");

	
		extent.createTest("Test5")
		.info("its an information mess")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		
		
		
		extent.flush();
		
		driver.close();
		
		Desktop.getDesktop().browse(new File("reports.html").toURI());	
	
	}
		public static String capture() throws IOException  {
			TakesScreenshot tss = (TakesScreenshot) driver;
			String base64 = tss.getScreenshotAs(OutputType.BASE64);
			return base64;			
		}
		public static String screenshot(String filename) throws IOException {
		
			TakesScreenshot tss = (TakesScreenshot) driver;
			File source = tss.getScreenshotAs(OutputType.FILE);
			File dest =  new File("./screenshot/"+filename);
			FileUtils.copyFile(source, dest);
			return dest.getAbsolutePath();
			
			
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
