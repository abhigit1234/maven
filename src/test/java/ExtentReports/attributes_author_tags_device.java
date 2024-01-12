package ExtentReports;

import java.awt.Desktop;
import java.io.*;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class attributes_author_tags_device{

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
		extent.attachReporter(spark);
		
		extent.createTest("Test1","pensylvania" )
		.assignAuthor("abhilash")
		.assignCategory("sanity")
		.assignDevice("chrome 99")
		.pass("passed");
		
		
		extent.createTest("Test2","pensylvania" )
		.assignAuthor("babu")
		.assignCategory("regression")
		.assignDevice("edge 9")
		.fail("failed");
		

		extent.createTest("Test3","pensylvania" )
		.assignAuthor(new String[] {"abhilash","naidu","babu","hyde"})
		.assignCategory("smoke","regression","sanity","functional","sanity","regression")
		.assignDevice("chrome 99","firefox 12","edge 9","chrome 99","edge 9")
		.skip("skipped")
		.skip(MarkupHelper.createLabel("Test3", ExtentColor.PURPLE));
		
		
		
		extent.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

		
	}



}