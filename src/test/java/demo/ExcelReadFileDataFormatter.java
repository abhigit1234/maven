package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
