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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class BackgroundStyles {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement fname = driver.findElement(By.name("firstname"));
		
		jse.executeScript("arguments[0].value='abhilash'",fname);
// border		jse.executeScript("document.getElementsByName(\"firstname\")[0].style.border=\"5px red dotted\";");
//background		jse.executeScript("document.getElementsByName(\"firstname\")[0].style.background=\"pink\";");
			jse.executeScript("document.getElementsByName(\"firstname\")[0].setAttribute('style','border:6px pink solid;background:yellow');");
	
	
	
	
	
	
	
	
	
	
	}
}