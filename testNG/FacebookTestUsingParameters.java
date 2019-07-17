package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FacebookTestUsingParameters {
	
	WebDriver driver;
 
    @Test
	@Parameters({ "userid", "password"})
	public void facebook(String userid, String password) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Akanksha\\Selenium\\chromedriver_win32_new\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys(userid);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();

	}
}
