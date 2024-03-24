package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WinHandlesGenericMethodUnlimitedWindows {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();
		driver.findElement(By.xpath("(//*[name()='svg'])[2]")).click();
		driver.findElement(By.xpath("(//*[name()='svg'])[3]")).click();
		driver.findElement(By.xpath("(//*[name()='svg'])[4]")).click();

		Set<String> wh = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(wh);
		getWinow("X", winList);
		System.out.println(driver.getTitle());
	
	
	}
	public static boolean getWinow(String winTitle, List<String> winList) {
		for(String e : winList) {
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(winTitle)) {
				System.out.println("found right window");
				return true;
			}
		}return false;
	}
}