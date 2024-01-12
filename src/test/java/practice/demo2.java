package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo2  {
	
	@DataProvider(name = "abhi")
	public Object[][] login() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\dataprovider.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[rowcnt-1][cellcnt];
		
		for (int i = 0; i < rowcnt-1; i++) {
			for (int j = 0; j < cellcnt; j++) {
			XSSFRow row =	sheet.getRow(i+1);
			XSSFCell cell = row.getCell(j);
			DataFormatter df = new DataFormatter();
			data[i][j] = df.formatCellValue(cell);
			
			}
		}
		wb.close();
		fis.close();
		return data;
	
	
	}
	

	@Test(dataProvider = "abhi")
	public void orangehrm(Object[] s) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		driver.findElement(By.name("username")).sendKeys((CharSequence)s[0]);
		driver.findElement(By.name("password")).sendKeys((CharSequence)s[1]);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
	}
	


}