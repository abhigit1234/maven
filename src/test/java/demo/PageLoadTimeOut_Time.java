package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeOut_Time {
	public static void main(String[] args) throws IOException{ //===DEFAULT PAGELOAD TIMEOUT IN SELENIUM IS 300 SEC = 5MIN

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		Instant startTime = Instant.now();

		System.out.println(startTime);

		driver.get("https://www.google.com");

		Instant endTime = Instant.now();

		System.out.println(endTime);
		
		Duration dur =  Duration.between(startTime, endTime);
	System.out.println(" total time is "+dur.toMillis());
		
		System.out.println(driver.getTitle());

		driver.quit();

	}

}
