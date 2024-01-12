package demo;

import java.sql.Date.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Dates {
	public static void main(String[] args) {
		
//====================================================Date 1 =======================
//		Calendar cal = Calendar.getInstance();
//		Date time = cal.getTime();
//		System.out.println(time);

	
//=====================================================Date 2========================		
	
//		Calendar cal = Calendar.getInstance();
//		String time = cal.getTime().toString().replace("", "").replace(":", " ");
//		System.out.println(time);

//======================================================Date 3========================	
	
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	System.out.println(ldt.format(dtf));
		
	}
}
