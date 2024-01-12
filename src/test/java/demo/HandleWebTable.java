package demo;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HandleWebTable {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> row =driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr"));
		List<WebElement> col =driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr[2]/td"));
		
		int row1 = row.size();
		int col1 = col.size();
		
		for(int i=1;i<row.size();i++) {
			for(int j=1;j<col.size();j++) {
				System.out.print("||" + driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr["+i+"]/td["+j+"]")).getText());
			
			}
			System.out.println();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	}
}