package demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> row =driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr"));
		List<WebElement> col =driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr[2]/td"));
		
		int row1 = row.size();
		int col1 = col.size();
		
		for(int i=1;i<row.size();i++) {
			for(int j=1;j<col.size();j++) {
				System.out.print("||" + driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr["+i+"]/td["+j+"]")).getText());
			
			}
			System.out.println();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	}
}