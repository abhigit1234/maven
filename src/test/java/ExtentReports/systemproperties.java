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


public class systemproperties {

	public static void main(String[] args) throws IOException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Capabilities cap =  ((RemoteWebDriver)driver).getCapabilities();
		System.out.println("browser name "+cap.getBrowserName());
		System.out.println("browser version  "+cap.getBrowserVersion());
		System.getProperties().list(System.out);
		System.out.println("country "+System.getProperty("user.country"));
		System.out.println("os "+System.getProperty("os.name"));
		System.out.println("java version "+System.getProperty("java.version"));
		System.out.println("username "+System.getProperty("user.name"));
		System.out.println("os version "+System.getProperty("os.version"));
		
		
		
		driver.quit();
		
		
	
	
	
	
	
	
	
	
	
	}
}