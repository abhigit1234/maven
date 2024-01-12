package demo;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelCreateFile {
	public static void main(String[] args) throws IOException  {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();

		//            NEW VERSION EXCEL (XLSX)

	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("test1");
	sheet.createRow(0);
	sheet.getRow(0).createCell(0).setCellValue("delhi");
	sheet.getRow(0).createCell(1).setCellValue("mumbai");		
	sheet.getRow(0).createCell(2).setCellValue("chennai");
	sheet.getRow(0).createCell(3).setCellValue("banglore");
	sheet.getRow(0).createCell(4).setCellValue("manipal");
	sheet.getRow(0).createCell(5).setCellValue("lucknow");
	sheet.getRow(0).createCell(6).setCellValue("jaipur");
	sheet.getRow(0).createCell(7).setCellValue("pune");
	
	sheet.createRow(1);
	sheet.getRow(1).createCell(0).setCellValue("abhilash");
	sheet.getRow(1).createCell(1).setCellValue("guggu");
	sheet.getRow(1).createCell(2).setCellValue("narsimha");
	sheet.getRow(1).createCell(3).setCellValue("ayansh");
	sheet.getRow(1).createCell(4).setCellValue("sushma");
	sheet.getRow(1).createCell(5).setCellValue("laxmidevi");
	sheet.getRow(1).createCell(6).setCellValue("hasanth");
	sheet.getRow(1).createCell(7).setCellValue("harshini");
	
	File file = new File("C:\\Users\\tubby\\eclipse-workspace\\excel\\testbabu.xlsx");
	FileOutputStream fileout = new FileOutputStream(file);
	workbook.write(fileout);
	workbook.close();
	
/*
		//          OLD VERSION EXCEL (XLS)
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("test1");
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("delhi");
		sheet.getRow(0).createCell(1).setCellValue("mumbai");		
		sheet.getRow(0).createCell(2).setCellValue("chennai");
		sheet.getRow(0).createCell(3).setCellValue("banglore");
		sheet.getRow(0).createCell(4).setCellValue("manipal");
		sheet.getRow(0).createCell(5).setCellValue("lucknow");
		sheet.getRow(0).createCell(6).setCellValue("jaipur");
		sheet.getRow(0).createCell(7).setCellValue("pune");
		
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("abhilash");
		sheet.getRow(1).createCell(1).setCellValue("guggu");
		sheet.getRow(1).createCell(2).setCellValue("narsimha");
		sheet.getRow(1).createCell(3).setCellValue("ayansh");
		sheet.getRow(1).createCell(4).setCellValue("sushma");
		sheet.getRow(1).createCell(5).setCellValue("laxmidevi");
		sheet.getRow(1).createCell(6).setCellValue("hasanth");
		sheet.getRow(1).createCell(7).setCellValue("harshini");
		
		File file = new File("C:\\Users\\tubby\\eclipse-workspace\\excel\\testabhi.xls");
		FileOutputStream fileout = new FileOutputStream(file);
		workbook.write(fileout);
		workbook.close();
	*/
	
	
	}
	
	
}
