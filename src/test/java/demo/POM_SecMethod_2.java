package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POM_SecMethod_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg/?next=%2Fsigup");
		POM_SecMethod_1 p = new   POM_SecMethod_1(driver);
		p.setfname("abhi");
		p.setlname("babu");
		p.setemail("ahilashnaidu21@gamil.com");
		p.setpassword("abhi");
		p.setdate();
		p.setmonth();
		p.setyear();
		p.setradio();
		
		
	}
}