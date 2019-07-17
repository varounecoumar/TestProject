package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterForDropdown {
	WebDriver driver;

	@Test
	@Parameters({ "category", "browser"})
	public void amazon(String category, String browser) {

		if (browser.equals("FFX")) {
			System.out.println("Test Starts Running In Firefox Browser.");
			System.setProperty("webdriver.gecko.driver",
					"D:\\Akanksha\\Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("CRM")) {// If value Is CRM then webdriver
											// will open chrome Browser.
			System.out.println("Test Starts Running In Google chrome.");
			System.setProperty("webdriver.chrome.driver",
					"D:\\Akanksha\\Selenium\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		WebElement elem = driver.findElement(By.id("searchDropdownBox"));
		Select dropdown = new Select(elem);
		dropdown.selectByVisibleText(category);
	}
}
