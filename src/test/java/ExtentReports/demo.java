package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demo.TakeScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {

public static	WebDriver driver;
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
	extent.attachReporter(spark);
	
	String base = capturebase64();
	String path = screen("google.png");
	
	extent.createTest("Test1").addScreenCaptureFromBase64String(base);
	extent.createTest("Test2").addScreenCaptureFromPath(path, "hello");
	
	extent.flush();
	driver.close();
	Desktop.getDesktop().browse(new File("reports.html").toURI());
	
	}
	
	public static String capturebase64() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
		
	
	}
	public static String screen(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//abhiscreen"+filename);
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("saved successfully");
		return dest.getAbsolutePath();
	}
	
}
