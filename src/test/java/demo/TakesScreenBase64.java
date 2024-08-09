package demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakesScreenBase64 {
	public static void main(String[] args) throws InterruptedException, IOException {

		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.espncricinfo.com/");
		Thread.sleep(2000);

		Date currdate = new Date();
		String date = currdate.toString().replace(" ", " ").replace(":", " ");
		System.out.println(date);
		TakesScreenshot tss= (TakesScreenshot) driver;
		String base64 = tss.getScreenshotAs(OutputType.BASE64);
		File destfile = new File(""+date+".png");
		FileOutputStream fos = new FileOutputStream(destfile);
		byte[] bytearr =  Base64.getDecoder().decode(base64);
		fos.write(bytearr);
		fos.close();
		
		driver.close();
	
	
	
	
	
	
	
	}

}