package demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Add_Extensions {
	public static void main(String[] args) throws IOException {

		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\tubby\\Desktop\\Extensions\\SelectorsHub 5.1.3.0.crx"),new File("C:\\Users\\tubby\\Desktop\\Extensions\\Chropath.crx"));
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.google.com");
	
		
	
	
	
	
	
	
	
	
	
	
	
	}
}
