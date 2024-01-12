package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadFile_IFCondition_EqualsTo {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\tubby\\eclipse-workspace\\excel\\login.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("LoginData");

		int rowcnt = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < rowcnt; i++) {
			XSSFRow row = sheet.getRow(i);

			XSSFCell cell = row.getCell(0);
			if(cell.getStringCellValue().equalsIgnoreCase("hasanth") ) {
			int cellcnt = row.getPhysicalNumberOfCells();
			for(int j=0;j<cellcnt;j++) {
			 cell =	row.getCell(j);
			
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
}