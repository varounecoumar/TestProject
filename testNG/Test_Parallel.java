package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test_Parallel {

	private WebDriver driver = null;

	@BeforeClass
	// parameter value will retrieved from testng.xml file's <parameter> tag.	
	@Parameters({ "browser" })
	public void setup(String browser) {
		if (browser.equals("FFX")) {
			System.out.println("Test Starts Running In Firefox Browser.");
			System.setProperty("webdriver.gecko.driver","D:\\Akanksha\\Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("CRM")) {// If value Is CRM then webdriver
											// will open chrome Browser.
			System.out.println("Test Starts Running In Google chrome.");
			System.setProperty("webdriver.chrome.driver",
					"D:\\Akanksha\\Selenium\\chromedriver_win32_new\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
	}
	
	@Test
	 public void verify_title(){   
	   String title = driver.getTitle();
	   Assert.assertEquals("Only Testing: LogIn", title);
	   System.out.println("Title Is Fine.");   
	 } 
	
	
	@Test
	public void test(){
		System.out.println("My name......");
	}
/*	 @Test
	 public void verify_message(){  
	  driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("UID1");
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1");
	  driver.findElement(By.xpath("//input[@value='Login']")).click();
	  String alert = driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  Assert.assertEquals("UserId Is : UID1  Password Is : pass1", alert);
	  System.out.println("Alert Is Fine.");  
	 } */
	/* @AfterClass 
	 public void closebrowser(){
	   driver.quit();  
	 }*/
}
