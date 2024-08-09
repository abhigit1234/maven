package demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks1 {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.sugarcrm.com");
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		
		int lists = list.size();
		System.out.println(lists);
		
		for (WebElement ele : list) {
		String url = ele.getAttribute("href");

			URL url1 = new URL(url);

			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.connect();
			int res = connection.getResponseCode();
			if (res >= 400) {
				System.err.println(url + connection.getResponseMessage() + "---> broken links");
			}

			else {
				System.out.println(url + "---->good link");

				connection.disconnect();
			}
		}
		driver.quit();

	}

	}
