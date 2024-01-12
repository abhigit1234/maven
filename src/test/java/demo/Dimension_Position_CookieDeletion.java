package demo;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dimension_Position_CookieDeletion {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");

		driver.manage().deleteAllCookies();

		Set<Cookie> set = driver.manage().getCookies();
		System.out.println(set);

		Dimension d = new Dimension(500, 500);
		driver.manage().window().setSize(d);

		Point p = new Point(150, 180);
		driver.manage().window().setPosition(p);
	}

}
