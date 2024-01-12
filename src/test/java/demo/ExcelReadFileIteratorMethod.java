package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReadFileIteratorMethod {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\selenium.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		Iterator iterator = sheet.iterator();
		while (iterator.hasNext()) {
			XSSFRow row = (XSSFRow) iterator.next();
			
			
			Iterator cell = row.cellIterator();

			while (cell.hasNext()) {
				XSSFCell cell1 = (XSSFCell) cell.next();

				switch (cell1.getCellType()) {
				case NUMERIC:
					System.out.print(cell1.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell1.getBooleanCellValue());
					break;
				case STRING:
					System.out.print(cell1.getStringCellValue());
					break;

				}
				System.out.print("||");
			}
			System.out.println();
		}

	}
}
