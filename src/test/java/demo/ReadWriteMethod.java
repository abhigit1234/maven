package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWriteMethod {
	public static void main(String[] args) throws IOException {

		Properties properties = new Properties();
		
		FileInputStream inputstream = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\demo\\src\\test\\resources\\properties\\testdata.properties");
		
		properties.load(inputstream);
		String browser = properties.getProperty("browser");
		System.out.println(browser);
		String url = properties.getProperty("url");
		System.out.println(url);
		
		FileOutputStream outputstream = new FileOutputStream("C:\\Users\\tubby\\eclipse-workspace\\demo\\src\\test\\resources\\properties\\testdata.properties");
		properties.setProperty("testdata", "9985400503");
		properties.store(outputstream, "this test case contains mob num");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}}