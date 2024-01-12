package demo;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadFile2 {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\selenium.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i <= row; i++) {
			XSSFRow currentrow = sheet.getRow(i);
			for (int j = 0; j < col; j++) {
				String value = currentrow.getCell(j).toString();
				System.out.print(value + "|| ");
			}
			System.out.println();
		}

	}
}