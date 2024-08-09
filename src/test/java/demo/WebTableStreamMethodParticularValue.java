package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableStreamMethodParticularValue {
	WebDriver driver;

	@Test
	public void webtable() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");

		//List<WebElement> tablelist = driver.findElements(By.xpath("//table[@id=\"example\"]//tbody//tr/td[1]"));
		
	//	List<String> collist = tablelist.stream().map(m -> m.getText()).collect(Collectors.toList());
		
		List<String> text;
		do {
			List<WebElement> tablelist1 = driver.findElements(By.xpath("//table[@id=\"example\"]//tbody//tr/td[1]"));

		 text = tablelist1.stream().filter(f -> f.getText().contains("Yuri Berry")).map(e -> getsalary(e)).collect(Collectors.toList());

			text.forEach(r -> System.out.println(r));

			if (text.size() < 1) {
				driver.findElement(By.cssSelector("#example_next")).click();
			}
		} while (text.size() < 1);
		driver.close();
	}

	public static String getsalary(WebElement x) {
		String salary = x.findElement(By.xpath("following-sibling::td[3]")).getText();
		return salary;
	}

}
