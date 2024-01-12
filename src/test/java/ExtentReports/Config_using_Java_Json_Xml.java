package ExtentReports;

import java.awt.Desktop;
import java.io.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Config_using_Java_Json_Xml {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("Doc Title");
//		spark.config().setReportName("abhilash");
//		spark.config().setTimeStampFormat("dd-MMM-yyyy HH-mm-ss");
//		spark.config().setCss(".badge-primary{background-color:#65df87}");
//		spark.config().setJs("document.getElementsByClassName('logo')[0].style.display=\"none\";");

//		ExtentSparkReporterConfig config = spark.config();
//		config.setTheme(Theme.DARK);
//		config.setDocumentTitle("Doc Title");
//		config.setReportName("abhilash");
//		config.setTimeStampFormat("dd-MMM-yyyy HH-mm-ss");
//		config.setCss(".badge-primary{background-color:#65df87}");
//		config.setJs("document.getElementsByClassName('logo')[0].style.display=\"none\";");

	spark.loadJSONConfig(new File("C:\\Users\\tubby\\eclipse-workspace\\MavenSeleniumWebDriver\\src\\test\\resources\\extent-report.json"));

		spark.loadXMLConfig(new File("C:\\Users\\tubby\\eclipse-workspace\\MavenSeleniumWebDriver\\src\\test\\resources\\extent-report.xml"));
		
		extent.attachReporter(spark);

		extent.createTest("Test1", "pensylvania").assignAuthor("abhilash").assignCategory("sanity")
				.assignDevice("chrome 99").pass("passed");

		extent.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}