package ExtentReports;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.text.DateFormat;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Add_System_And_Envi_Information {

	public static void main(String[] args) throws IOException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Capabilities cap =  ((RemoteWebDriver)driver).getCapabilities();
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
		
		ExtentSparkReporterConfig conf =  spark.config();
		extent.setSystemInfo("os",System.getProperty("os.name"));
		extent.setSystemInfo("java version",System.getProperty("java.version"));
		extent.setSystemInfo("browser name",cap.getBrowserName());
		extent.setSystemInfo("browser version",cap.getBrowserVersion());
		extent.setSystemInfo("App url", "www.google.com");
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		
		extent.attachReporter(spark);
		
		extent.createTest("Test 1").info(MarkupHelper.createCodeBlock("hello"));
				
		extent.flush();
		driver.close();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	
	
	
	
	
	
	
	
	
	
	
	}
}