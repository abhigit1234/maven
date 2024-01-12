package demo;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateValidatingWithExceptionMessage {
	public static void main(String[] args) throws Exception  {


	String targetdate = "30/feb/1989";
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MMM/yyyy");
	try {
		dateformat.setLenient(false);
		Date formatteddate = dateformat.parse(targetdate);
		System.out.println(formatteddate);
	} catch (ParseException e) {
		throw new Exception("Invalid date entered");
	}
	
	
	
	
	
	}
}