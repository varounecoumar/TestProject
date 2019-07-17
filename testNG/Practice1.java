package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice1 {
	
	WebDriver driver;
	
  @Test(dataProvider = "SearchProvider", dataProviderClass=Practice.class)
  public void f(String name, String password) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Akanksha\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(name);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	  
  }
}
