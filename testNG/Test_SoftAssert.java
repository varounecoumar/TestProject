package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;

public class Test_SoftAssert {

	SoftAssert s_assert;
	String Actualtext;
	WebDriver driver;

	@BeforeClass
	public void load_url() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Akanksha\\Selenium\\chromedriver_win32_new\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}

	
	  /*@Test 
	  //In this method, If any assertion fails then execution will be aborted. 
	  public void hard_assert_text() { 
      String expectedTitle ="Facebook1 - Log In or Sign Up";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  driver.findElement(By.id("email")).sendKeys("akanksha24.a@gmail");
	  driver.findElement(By.id("pass")).sendKeys("password");
	  driver.findElement(By.id("loginbutton")).click();
	  
	  }*/
	 

	@Test
	// In this method, Test execution will not abort even If any assertion fail.
	// Full Test will be executed.
	public void soft_assert_ext() {
		
		s_assert = new SoftAssert();

		String expectedTitle = "Welcome to 1Facebook - Log In, Sign Up or Learn More";
		String actualTitle = driver.getTitle();
		s_assert.assertEquals(actualTitle, expectedTitle);
		String currentUrl = driver.getCurrentUrl();
		s_assert.assertEquals(currentUrl, "https://www.facebook.com/");		
		driver.findElement(By.id("email")).sendKeys("akanksha24.a@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("loginbutton")).click();
		s_assert.assertAll();
	}

	/*
	 * @AfterClass public void Closebrowser(){ driver.quit(); }
	 */
}
