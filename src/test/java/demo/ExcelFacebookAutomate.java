package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelFacebookAutomate {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
		File file = new File("C:\\Users\\tubby\\eclipse-workspace\\excel\\facebooklogin.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowcnt = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i < rowcnt; i++) {
			XSSFRow row = sheet.getRow(i);
			
		String FIRSTNAME =	row.getCell(0).getStringCellValue();
		String SURNAME =	row.getCell(1).getStringCellValue();
		int MOBILENUMBER =	 (int) row.getCell(2).getNumericCellValue();
		String PASSWORD =	row.getCell(3).getStringCellValue();


			 
			 driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
			 Thread.sleep(1000);
			 driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
			 Thread.sleep(1000);
			 driver.findElement(By.name("lastname")).sendKeys(SURNAME);
			 Thread.sleep(1000);
			 driver.findElement(By.name("reg_email__")).sendKeys(String.valueOf(MOBILENUMBER));
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys(PASSWORD);
			 Thread.sleep(1000);
			 driver.navigate().refresh();
}
		driver.close();
}}