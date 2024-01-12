package practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;


public class extentdemo {

	@Test
	public void extent() throws InterruptedException, IOException {	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark_all = new ExtentSparkReporter("allreports.html");
	ExtentSparkReporter spark_pass = new ExtentSparkReporter("passedreports.html");
	ExtentSparkReporter spark_fail = new ExtentSparkReporter("failedreports.html");
	ExtentSparkReporter spark_skipped = new ExtentSparkReporter("skippedreports.html");
	ExtentSparkReporter spark_warning = new ExtentSparkReporter("warningreports.html");
	
	spark_pass.filter().statusFilter().as(new Status[] {Status.PASS});
	spark_fail.filter().statusFilter().as(new Status[] {Status.FAIL});
	spark_skipped.filter().statusFilter().as(new Status[] {Status.SKIP});
	spark_warning.filter().statusFilter().as(new Status[] {Status.WARNING});
	extent.attachReporter(spark_all,spark_pass,spark_fail,spark_skipped,spark_warning);
	
	
	extent.createTest("Test1")
	.assignAuthor("abhi")
	.assignCategory("smoke")
	.assignDevice("chrome")
	.pass("passed");
	
	extent.createTest("Test2")
	.assignAuthor("naidu")
	.assignCategory("sanity")
	.assignDevice("edge")
	.fail("failed");
	
	extent.createTest("Test3")
	.assignAuthor("harshini")
	.assignCategory("regression")
	.assignDevice("firefox")
	.skip("skipped");
	
	extent.createTest("Test4")
	.assignAuthor("hasanth")
	.assignCategory("functional")
	.assignDevice("chromium")
	.warning("warning");
	
	
	
	
	extent.flush();

	Desktop.getDesktop().browse(new File("allreports.html").toURI());
	Desktop.getDesktop().browse(new File("passedreports.html").toURI());
	Desktop.getDesktop().browse(new File("failedreports.html").toURI());
	Desktop.getDesktop().browse(new File("skippedreports.html").toURI());
	Desktop.getDesktop().browse(new File("warningreports.html").toURI());
	}
}