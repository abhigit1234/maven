package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateOnlyFor_Pass_Fail_Skipped_warning {

	public static void main(String[] args) throws IOException  {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark_all = new ExtentSparkReporter("allreports.html");
		ExtentSparkReporter spark_passed = new ExtentSparkReporter("passed.html");
		ExtentSparkReporter spark_failed = new ExtentSparkReporter("failed.html");
		ExtentSparkReporter spark_skipped = new ExtentSparkReporter("skipped.html");
		ExtentSparkReporter spark_warning = new ExtentSparkReporter("warning.html");
		
		
		spark_passed.filter().statusFilter().as(new Status[] {Status.PASS});
		spark_failed.filter().statusFilter().as(new Status[] {Status.FAIL});
		spark_skipped.filter().statusFilter().as(new Status[] {Status.SKIP});
		spark_warning.filter().statusFilter().as(new Status[] {Status.WARNING});
		
		extent.attachReporter(spark_all,spark_passed,spark_failed,spark_skipped,spark_warning);
		
		extent
		.createTest("Test 1")
		.pass("passed")
		.assignAuthor("abhi")
		.assignCategory("smoke")
		.assignDevice("chrome 115");
		
		extent
		.createTest("Test 2")
		.fail("failed")
		.assignAuthor("naidu")
		.assignCategory("sanity")
		.assignDevice("firefox 22");
		
		extent
		.createTest("Test 3")
		.skip("skipped")
		.warning("warning")
		.assignAuthor("durgumahanthi")
		.assignCategory("regression")
		.assignDevice("edge 11");
		
		extent
		.createTest("Test 4")
		.warning("warning")
		.assignAuthor("harshini")
		.assignCategory("functional")
		.assignDevice("chromium 34");
		
		//spark_warning.config().setCss(".badge-primary{background-color:#65df87}");
		
		
		
		extent.flush();
		Desktop.getDesktop().browse(new File("allreports.html").toURI());
		Desktop.getDesktop().browse(new File("passed.html").toURI());
		Desktop.getDesktop().browse(new File("failed.html").toURI());
		Desktop.getDesktop().browse(new File("skipped.html").toURI());
		Desktop.getDesktop().browse(new File("warning.html").toURI());
		

		
	}
}