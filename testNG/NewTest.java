package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Akanksha\\Selenium\\chromedriver_win32_new\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");		

	}

	@Test
	public void f1() {
		String expTitle = "Facebook";
		String actTitle = driver.getTitle();
		if(expTitle.equals(actTitle)){
			System.out.println("The titles are same....");
		}
		else{
			throw new SkipException("The titles are not same");
		}
		  driver.findElement(By.id("email")).sendKeys("akanksha24.a@gmail.com");
		  driver.findElement(By.id("pass")).sendKeys("Password");
		  driver.findElement(By.xpath("//input[@value='Log In']"));
		
	}
	
	@Test
	public void f2(){
		  System.out.println("I'm in f2");
		  driver.findElement(By.id("email")).sendKeys("akanksha24.a@gmail.com");
		  driver.findElement(By.id("pass")).sendKeys("Password");
		  driver.findElement(By.xpath("//input[@value='Log In']"));
	}
	
	@AfterTest
	public void quitBrowser(){
		driver.quit();
		
	}
}
