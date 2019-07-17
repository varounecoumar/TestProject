package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AmazonSearch {
	
	private WebDriver driver;
  @Test(dependsOnMethods={"openBrowser"},groups={"A"})
  public void fSearch() {
	  
	  List<WebElement> allCategories;

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		
		//Following code will select the dropdown
		Select category = new Select(dropdown);
		category.selectByVisibleText("Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		driver.findElement(By.className("nav-input")).click();
  }
  
  @Test(groups={"B"})
  public void f2(){
	  System.out.println("Inside Amazon Search........");
  }
  
  @Test(groups={"B"})
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\Akanksha\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in");		
	}

  /*@AfterTest
  public void quitBrowser() {
	  try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.quit();
  }*/

}
