package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadFileIteratorIfConditionSheetSelector {

	

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\tubby\\eclipse-workspace\\excel\\login.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		int numsheet = wb.getNumberOfSheets();
		for (int i = 0; i < numsheet; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("LoginDatA"))
				;
			{
				 sheet = wb.getSheetAt(i);
			}
		}
			Iterator itrow = sheet.iterator();
			while(itrow.hasNext()) {
			Row row = (Row) itrow.next();
			
			Iterator itcell = row.cellIterator();
		Cell cell = (Cell) itcell.next();
		if(cell.getStringCellValue().equalsIgnoreCase("hasanth")) {
			while(itcell.hasNext()) {
				cell = (Cell) itcell.next();
			System.out.print("||"+cell);
			}		
		System.out.println();
		}
		
			}
	
	}
}