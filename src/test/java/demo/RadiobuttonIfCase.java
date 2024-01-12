package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadiobuttonIfCase {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");

		String gender = "1";
		List<WebElement> sex = driver.findElements(By.name("sex"));
		sex.size();
		for (WebElement ele : sex) {
		String value =	ele.getAttribute("value");
			if(value.equals(gender)) {
				ele.click();
			}
		}
		
	
	
	}
}
