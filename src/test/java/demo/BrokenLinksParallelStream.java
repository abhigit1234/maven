package demo;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksParallelStream {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());

		List<String> urllist = new ArrayList<String>();
		for (WebElement ele : list) {
			String url = ele.getAttribute("href");
			urllist.add(url);
			// brokenlink(url);

		}
		long stTime = System.currentTimeMillis();

		urllist.parallelStream().forEach(e -> brokenlink(e));

		long endTime = System.currentTimeMillis();
		System.out.println("total time is "+(endTime-stTime));
		driver.quit();
	}

	public static void brokenlink(String linkurl) {
		try {

			URL url = new URI(linkurl).toURL();
			HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.connect();
			if (httpconnection.getResponseCode() >= 400) {
				System.err.println(httpconnection + "---->" + "brokenlink");
			}
			else {
				System.out.println(httpconnection + "---->" + httpconnection.getResponseMessage());
			}

		} 
		catch (Exception e) {

		}

	}
}
