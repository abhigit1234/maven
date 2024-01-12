package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicExtentReport{
	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
		extent.attachReporter(spark);
		ExtentTest test1 = extent.createTest("Test1");
		test1.pass("passed1");
	ExtentTest test2 = extent.createTest("Test2");
		test2.fail("failed2");
		
		ExtentTest test3 = extent.createTest("Test3");
		test3.skip("skipped3");
		ExtentTest test4 = extent.createTest("Test4");
		test4.log(Status.WARNING, "Test4warnings");	
		extent.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
		
	}
}