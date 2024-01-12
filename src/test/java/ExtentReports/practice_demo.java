package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice_demo {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
	
		
		ExtentReports extent = new ExtentReports();
		
		ExtentSparkReporter spark_all = new ExtentSparkReporter("allreports.html");
		ExtentSparkReporter spark_passed = new ExtentSparkReporter("passed.html");
		ExtentSparkReporter spark_failed = new ExtentSparkReporter("failed.html");
		ExtentSparkReporter spark_skipped = new ExtentSparkReporter("skipped.html");
		ExtentSparkReporter spark_warning = new ExtentSparkReporter("warnings.html");
		
	
		spark_passed.filter().statusFilter().as(new Status[] {Status.PASS});
		spark_failed.filter().statusFilter().as(new Status[] {Status.FAIL});
		spark_skipped.filter().statusFilter().as(new Status[] {Status.SKIP});
		spark_warning.filter().statusFilter().as(new Status[] {Status.WARNING});
	
		
		extent.attachReporter(spark_all,spark_passed,spark_failed,spark_skipped,spark_warning);


		
		extent.createTest("test1").pass("pass");
		extent.createTest("test2").fail("failed");
		extent.createTest("test3").skip("skipped");
		extent.createTest("test4").warning("warnings");
		

		extent.flush();
		Desktop.getDesktop().browse(new File("allreports.html").toURI());
		Desktop.getDesktop().browse(new File("passed.html").toURI());
		Desktop.getDesktop().browse(new File("failed.html").toURI());
		Desktop.getDesktop().browse(new File("skipped.html").toURI());
		Desktop.getDesktop().browse(new File("warnings.html").toURI());

	}
}
