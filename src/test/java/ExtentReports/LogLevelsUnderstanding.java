package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogLevelsUnderstanding
{
	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
		extent.attachReporter(spark);
		extent.createTest("Test")
		.pass("pass")
		.fail("fail")
		.skip("skip")
		.warning("warnings")
		.info("info");
		
		extent.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
		
		
		/*Log order Execution:
				Fail,
				skipped,
				warning,
				pass,
				info
		*/		
			
	}
}