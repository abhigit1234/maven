package demo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapLogin {
	public static void main(String[] args) throws Exception {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Set1", "admin:admin");
		map.put("Set2", "admin123:naidu123");

		System.out.println(map.get("Set1"));
		System.out.println(map.get("Set2"));

		String[] arr = map.get("Set2").split(":");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost/opencart/upload/admin/");
		driver.findElement(By.name("username")).sendKeys(arr[0]);
		driver.findElement(By.name("password")).sendKeys(arr[1]);
		Thread.sleep(2000);
		driver.close();

	}

}
