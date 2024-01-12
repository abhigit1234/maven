package practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest extenttest;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void initialiseBrowser(ITestContext context ,String browserName) {
		switch (browserName.toLowerCase()) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
	Capabilities	cap = ((RemoteWebDriver)driver).getCapabilities();
	String device = cap.getBrowserName()+"_"+cap.getBrowserVersion().substring(0, cap.getBrowserVersion().indexOf("."));
	String author = context.getCurrentXmlTest().getParameter("author");
	extenttest =	extent.createTest(context.getName());
	extenttest.assignAuthor(author);
	extenttest.assignDevice(device);
		
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@BeforeSuite
	public void initialiseReports() {
		 extent = new ExtentReports();
		 ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
		 extent.attachReporter(spark);
		 extent.setSystemInfo("os name", System.getProperty("os.name"));
		 extent.setSystemInfo("user name", System.getProperty("user.name"));
		 extent.setSystemInfo("country name", System.getProperty("country.name"));
		 extent.setSystemInfo("os version", System.getProperty("os.version"));
		 extent.setSystemInfo("java version", System.getProperty("java.version"));
		 
	}
	
	@AfterSuite
	public void generateExtentReports() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
	}

	@BeforeMethod
	public void groups(Method m) {
		extenttest.assignCategory(m.getAnnotation(Test.class).groups());
	}
	@AfterMethod
	public void checkStatus(Method m, ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		String path =	capture(result.getTestContext().getName()+" "+result.getMethod().getMethodName()+".png");
		extenttest.addScreenCaptureFromPath(path);
		extenttest.fail(result.getThrowable());
		
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extenttest.pass(m.getName()+" is passeddddd ");
		}
	}
	
	public static String capture(String filename) {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMMyyyy_HHmmss");
		String date = ldt.format(dtf);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+date+" _ " + filename);
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("saved screen shot successfully");
		return dest.getAbsolutePath();
	}

}