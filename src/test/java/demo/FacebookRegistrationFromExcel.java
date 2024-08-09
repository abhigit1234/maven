package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistrationFromExcel {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		driver = new ChromeDriver();

		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\facebook.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("testdata1");
		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int i = 1; i < rowcnt; i++) {

			XSSFRow row = sheet.getRow(i);
			String fname = row.getCell(0).getStringCellValue();
			String lname = row.getCell(1).getStringCellValue();
			int mob = (int) row.getCell(2).getNumericCellValue();
			String password = row.getCell(3).getStringCellValue();
			int day = (int) row.getCell(4).getNumericCellValue();
			String month = row.getCell(5).getStringCellValue();
			int year = (int) row.getCell(6).getNumericCellValue();
			int sex = (int) row.getCell(7).getNumericCellValue();
			
			driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
			driver.findElement(By.name("firstname")).sendKeys(fname);
			driver.findElement(By.name("lastname")).sendKeys(lname);
			driver.findElement(By.name("reg_email__")).sendKeys(String.valueOf(mob));
			driver.findElement(By.name("reg_passwd__")).sendKeys(password);
			WebElement d = driver.findElement(By.id("day"));
			Select sel1 = new Select(d);
			sel1.selectByVisibleText(String.valueOf(day));
	//		Thread.sleep(2000);
			WebElement m = driver.findElement(By.id("month"));
			Select sel2 = new Select(m);
			sel2.selectByVisibleText(month);
	//		Thread.sleep(2000);
			WebElement y = driver.findElement(By.id("year"));
			Select sel3 = new Select(y);
			sel3.selectByVisibleText(String.valueOf(year));
	//		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.name("sex"));
		for (WebElement ele : list) {
		String value =	ele.getAttribute("value");
		if(value.equals(String.valueOf(sex))) {
			ele.click();
			
		}
		
		}
		
		
		
		Thread.sleep(3000);
		driver.navigate().refresh();

		}
		driver.close();
	}

}
