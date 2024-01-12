package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReadFile1 {
	 public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\selenium.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcnt = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < rowcnt; i++) {
			XSSFRow row = sheet.getRow(i);
			int cellcnt = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellcnt; j++) {
				XSSFCell cell = row.getCell(j);
				System.out.print("||"+getCellValue(cell));
			}
		System.out.println();
		}
			wb.close();
			fis.close();
	}		
	

	public static String getCellValue(XSSFCell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case STRING:
			return cell.getStringCellValue();

		default:
			return cell.getStringCellValue();
		}
	}

}
