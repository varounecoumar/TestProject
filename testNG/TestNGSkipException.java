package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestNGSkipException {

	public static WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Akanksha\\Selenium\\chromedriver_win32_new\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	}

	@Test
	public void Intensional_Skip() {
		System.out.println("In Verify_Title");
		String titl = driver.getTitle();

		System.out.println(titl);

		if (titl.equals("Only Testing: New Test")) {
			// To Skip Test if a certain condition is encountered
			throw new SkipException("Test Check_Checkbox Is Skipped");

		} else {
			System.out.println("Check the Checkbox");
			driver.findElement(By.xpath("//input[@value='Bike']")).click();
		}
		System.out.println("After If Else");
	}

	@Test
	public void Radio_check() {
		System.out.println("In Check_Radio");
		driver.findElement(By.xpath("//input[@value='male']")).click();
	}

	
	//  @AfterTest public void tearDown() throws Exception { driver.quit(); }
	 
}
