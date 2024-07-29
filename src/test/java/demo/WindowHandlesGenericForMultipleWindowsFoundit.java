package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesGenericForMultipleWindowsFoundit {
	static WebDriver driver;
	public static void main(String[] args)throws Exception {
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.foundit.in/");
	driver.findElement(By.xpath("/html/body/section/div[3]/div/div[1]/div/a[1]/div/div[4]")).click();
	driver.findElement(By.xpath("/html/body/section/div[3]/div/div[1]/div/a[2]/div/div[4]")).click();
	driver.findElement(By.xpath("/html/body/section/div[3]/div/div[1]/div/a[3]/div/div[4]")).click();
	driver.findElement(By.xpath("/html/body/section/div[3]/div/div[1]/div/a[4]/div/div[4]")).click();
	
	Set<String> wh =	driver.getWindowHandles();
	List<String> hlist = new ArrayList<String>(wh);
	getWindow("Prep", hlist);
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/main/main/section[1]/div/div/div/div[2]/div/a[1]/span")).click();
	Set<String> wh1 =	driver.getWindowHandles();
	List<String> hlist1 = new ArrayList<String>(wh1);
	getNewWindow("Career Services - Mock Interview", hlist1);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[contains(@class,'justify-between')]/button")).click();
	System.out.println(driver.getCurrentUrl());
	
	getWindow("Career Services | Boost", hlist);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	System.out.println(driver.getCurrentUrl());
	Thread.sleep(2000);
	
	getNewWindow("Registration | foundit India", hlist1);
	driver.findElement(By.id("mobileNumber")).sendKeys("9985400503");
	driver.findElement(By.xpath("(//div[@class='toggleFill'])[1]")).click();
	driver.findElement(By.id("emailId")).sendKeys("abhilashnaidu2100");
	driver.findElement(By.id("password")).sendKeys("lolololo");
	driver.findElement(By.xpath("(//div[@class='toggleFill'])[2]")).click();
	Thread.sleep(2000);
	
	driver.quit();
	
	}	public static boolean getWindow(String val,List<String> hlist) {
		for (String ele : hlist) {
			String title = driver.switchTo().window(ele).getTitle();
			if(title.contains(val)) {
				System.out.println("found right window");
				System.out.println(title);
				return true;
			}
		}return false;
	}
	public static boolean getNewWindow(String val,List<String> hlist) {
		for (String ele : hlist) {
			String title = driver.switchTo().window(ele).getTitle();
			if(title.equalsIgnoreCase(val)) {
				System.out.println("found right window");
				System.out.println(title);
				return true;
			}
		}return false;
	}
	





}