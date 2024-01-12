package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshotsAttach	{
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		String base64 = capture();
		String path = screen("google.png");
		
		Date cur = new Date();
		String date = cur.toString().replace(" ", " ").replace(":", " ");
		System.out.println(date);
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(""+date+".html");
		extent.attachReporter(spark);
		
		extent.createTest("base64")
		.addScreenCaptureFromBase64String(base64,"its base64 screen");
		
		extent.createTest("Test1")
		.addScreenCaptureFromBase64String(base64,"its base64 screen1")
		.addScreenCaptureFromBase64String(base64,"its base64 screen2")
		.addScreenCaptureFromBase64String(base64,"its base64 screen3")
		.addScreenCaptureFromBase64String(base64,"its base64 screen4");
		
		extent.createTest("path")
		.addScreenCaptureFromPath(path,"google");
		
		extent.createTest("Test2")
		.addScreenCaptureFromPath(path,"google1")
		.addScreenCaptureFromPath(path,"google2")
		.addScreenCaptureFromPath(path,"google3")
		.addScreenCaptureFromPath(path,"google4")
		.addScreenCaptureFromPath(path,"google5");
		
		Throwable t1 = new Throwable("its an exception");
		
		extent.createTest("Test3")
		.info("this is base64")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "hello").build())
		.fail("this is base64",MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "hello").build())
		.fail(t1, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "hello").build());
		
		Throwable t2 = new RuntimeException();
		
		extent.createTest("Test4")
		.info("this is path")
		.fail( MediaEntityBuilder.createScreenCaptureFromPath(path).build())	
		.fail( MediaEntityBuilder.createScreenCaptureFromPath(path,"hello").build())
		.fail("this is path", MediaEntityBuilder.createScreenCaptureFromPath(path, "hello").build())
		.fail(t2,MediaEntityBuilder.createScreenCaptureFromPath(path, "hello").build());
		
		extent.flush();
		driver.close();
		Desktop.getDesktop().browse(new File(""+date+".html").toURI());
	}
public static String capture() {
	TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
}
public static String screen(String filename) throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
	File source =	ts.getScreenshotAs(OutputType.FILE);
	File destfile = new File("ebay.png");
	FileUtils.copyFile(source, destfile);
	return destfile.getCanonicalPath();
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		
		
		
		
		
		
	}


