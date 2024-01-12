package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogDifferentTypesInformation {
public static void main(String[] args) throws IOException {
	
			ExtentReports extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");
			extent.attachReporter(spark);
			
	//==========================================JSON,XML===========
			
			String json = "{\"menu\": {\r\n"
					+ "  \"id\": \"file\",\r\n"
					+ "  \"value\": \"File\",\r\n"
					+ "  \"popup\": {\r\n"
					+ "    \"menuitem\": [\r\n"
					+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
					+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
					+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
					+ "    ]\r\n"
					+ "  }\r\n"
					+ "}}";
		
		String xml = "<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>\r\n"
				+ "";

	//=========================ARRAYS========================
		
		List<String> str = new ArrayList<String>();
		str.add("abhi");
		str.add("hyd");
		str.add("babu");
		
		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(1);
		in.add(2);
		in.add(3);
		
		ArrayList<Object> obj = new ArrayList<Object>();
		obj.add("xyz");
		obj.add('a');
		obj.add(5);
	 	
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "maa");
		map.put(200, "zee");
		map.put(300,"gemini");
		
		Set<Integer> set = map.keySet();

		
		
		
		extent.createTest("json").info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
		extent.createTest("xml").info(MarkupHelper.createCodeBlock(xml));
		
		
		extent.createTest("list of string").info(MarkupHelper.createOrderedList(str));
		extent.createTest("list of string").info(MarkupHelper.createUnorderedList(str));
		
		extent.createTest("list of integer").info(MarkupHelper.createOrderedList(in));
		extent.createTest("list of integer").info(MarkupHelper.createUnorderedList(in));	
		
		extent.createTest("list of object").info(MarkupHelper.createOrderedList(obj));
		extent.createTest("list of object").info(MarkupHelper.createUnorderedList(obj));
		
		extent.createTest("list of mapping").info(MarkupHelper.createOrderedList(map));
		extent.createTest("list of mapping").info(MarkupHelper.createUnorderedList(map));
		
		extent.createTest("list of set").info(MarkupHelper.createOrderedList(set));
		extent.createTest("list of set").info(MarkupHelper.createUnorderedList(set));
		
	//=================EXCEPTION===================
		String exception1;
		try {
			int a=2/0;
		} catch (Exception e) {
			extent.createTest("exception1").fail(e);
		}
		
		Throwable thr = new RuntimeException("custom exception");
		extent.createTest("exception test method").fail(thr);
		
	//====================HIGHLIGHTING TEXT ==================

			extent.createTest("Highlight log test")
			.info("this is not a highlighted test")
			.info(MarkupHelper.createLabel("this is highlighted test", ExtentColor.BLUE));

			extent.createTest("Highlight log test")
			.fail("this is not a highlighted test")
			.fail(MarkupHelper.createLabel("this is highlighted test",ExtentColor.RED));
		
		extent.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

		
			}
	}