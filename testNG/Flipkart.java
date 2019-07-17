package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Flipkart {
	
	private WebDriver driver;
  @Test(groups={"B"})
  public void f() {
	  System.out.println("Opening Flipkart.....");
  }
  
  @Test(groups={"A"})
  public void f4(){
	  System.out.println("Inside Amazon Search........");
  }
  
  @BeforeTest
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\Akanksha\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com");		
	}

  @AfterTest
  public void afterTest() {
	  try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.quit();
  }

}
