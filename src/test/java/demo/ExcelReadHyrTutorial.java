package demo;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReadHyrTutorial {

	@Test
	public void loginData() throws Exception{
		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\Desktop\\demo.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[row-1][col];
		for(int i=0;i<row-1;i++) {
			for(int j=0;j<col;j++) {
			XSSFCell cells = 	sheet.getRow(i+1).getCell(j);
			DataFormatter df = new DataFormatter();
			data[i][j] = df.formatCellValue(cells);
			
			}
		}
		wb.close();
		fis.close();

	for(Object[] x : data) {
		System.out.println(Arrays.toString(x));
	}
		}

}
