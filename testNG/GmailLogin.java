package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GmailLogin {

	WebDriver driver;
	ReadExcelData data;

	@DataProvider(name="LC")
	public Object[][] LoginCredentials() {	
		
		data = new ReadExcelData();		
		Object[][] Cred = data.createDataArray("C:\\Users\\AkkiAsh\\Desktop\\Edureka\\DataMT.xlsx", "Data");

		return Cred; // Returned Cred
	}

	@Test(dataProvider = "LC")
	public void testLogin(String Userid, String Pass) {

		try {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Akanksha\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
			driver.get("http://www.gmail.com");

			//String title = driver.getTitle();
			//System.out.print("\nCurrent page title is : " + title);
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Email")).sendKeys(Userid);
			driver.findElement(By.id("next")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("Passwd")).clear();
			driver.findElement(By.id("Passwd")).sendKeys(Pass);
			driver.findElement(By.id("signIn")).click();
			System.out.println("Clicked on signin button");
			Thread.sleep(3000);
			closeBrowser();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
	
	public void closeBrowser(){
		driver.quit();
	}
	
}
