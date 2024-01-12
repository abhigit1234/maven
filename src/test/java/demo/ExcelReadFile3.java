package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadFile3 {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\selenium.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcnt = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < rowcnt; i++) {
			XSSFRow row = sheet.getRow(i);
			int colcnt = row.getPhysicalNumberOfCells();
			for (int j = 0; j < colcnt; j++) {
				XSSFCell cell = row.getCell(j);
				
				switch(cell.getCellType()) {
				case NUMERIC:System.out.print(cell.getNumericCellValue());break;
				case STRING:System.out.print(cell.getStringCellValue());break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print("||");
				
				
			}
		System.out.println();
		}

		
	
	
	
	}
}