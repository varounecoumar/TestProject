package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAnnotations {

	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Akanksha\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Before Test::::::::::::");

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
	}

	@AfterTest
	public void exitApplication() {
		System.out.println("After Test:::::::::");
		driver.quit();

	}

	@BeforeMethod
	public void verifyTitle() {

		/*String expectedTitle = "Welcome to Facebook - Log In, Sign Up or Learn More";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);*/
		System.out.println("Before method::::::::::::::::");

	}

	@AfterMethod
	public void goBackToHomePage() {

		System.out.println("After Method:::::::::");

	}

	@Test(dataProvider = "loginCredentials")
	public void loginToFacebook(String userId, String pass) {

		driver.findElement(By.id("email")).sendKeys(userId);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.id("loginbutton")).click();

	}

	@DataProvider
	public Object[][] loginCredentials() {
		// Created two dimensional array with 1 rows and 2 columns.
		// 1 row represents test has to run 1 times.
		// 2 columns represents 2 data parameters.
		Object[][] Cred = new Object[1][2];

		Cred[0][0] = "akanksha24.a@gmail.com";
		Cred[0][1] = "aarnamybaby@24";

		return Cred; // Returned Cred
	}
	
	@Test
	public void testCase(){
		System.out.println("Just another test case....");
	}

}
