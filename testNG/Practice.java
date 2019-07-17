package testNG;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice {
	WebDriver driver;
	
	@Test(dataProvider = "SearchProvider")
	public void methodA(String name, String value) {		
		try {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Akanksha\\Selenium\\chromedriver_win32_new\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.gmail.com");
		
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Email")).sendKeys(name);
			driver.findElement(By.id("next")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("Passwd")).clear();
			driver.findElement(By.id("Passwd")).sendKeys(value);
			Thread.sleep(2000);
			driver.close();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(dataProvider = "SearchProvider")
	public void methodB(String name) {
		System.out.println(name);

	}

/*	@DataProvider(name = "SearchProvider")
	public Object[][] valuesToTest() {
		Object[][] valueArray = null;

		valueArray = new Object[][] { { "akanksha24.a@gmail.com", "abc" },
				{ "ashishmishra.manit@gmail.com", "xyz" },
				{ "abc@gmail.com", "fgh" } };
		return valueArray;
	}*/

	
	@DataProvider(name = "SearchProvider")
	public Object[][] valuesToTest(Method m) {
		Object[][] valueArray = null;
		if (m.getName().equalsIgnoreCase("methodA")) {
			valueArray = new Object[][] { { "akanksha24.a@gmail.com", "abc" },

			{ "ashishmishra.manit@gmail.com", "xyz" } };

		} else if (m.getName().equalsIgnoreCase("methodB")) {
			valueArray = new Object[][] { { "Akanksha" },{"Ashish"}, {"Aarna"} };

		}
		else if (m.getName().equalsIgnoreCase("f")) {
			valueArray = new Object[][] { { "akanksha24.a@gmail.com", "password1" },

					{ "ashishmishra.manit@gmail.com", "password2" } };

		}
		return valueArray;
	}
	 
}
