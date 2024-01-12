package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.common.SystemCache;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

public class ExcelReadFileDataFormatter {
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\\\Users\\\\tubby\\\\Desktop\\\\SELENIUM\\\\selenium.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getPhysicalNumberOfCells();
	for (int i = 0; i < rowcnt; i++) {
	for (int j = 0; j < cellcnt; j++) {
		XSSFCell cell =	sheet.getRow(i).getCell(j);
		DataFormatter df = new DataFormatter();
		String format = df.formatCellValue(cell);
		System.out.print("||"+ format);
	}
	System.out.println();
	}
	
	
	}

}
