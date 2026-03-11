package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Guru99LoginTest {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		// Launch Firefox Browser
		driver = new FirefoxDriver();

		// Open the URL
		driver.get("http://www.demo.guru99.com/V4/");

		// Maximize browser
		driver.manage().window().maximize();
	}

	@Test
	public void loginTest() {

		// Enter UserId
		driver.findElement(By.name("uid")).sendKeys("mngr654832");

		// Enter Password
		driver.findElement(By.name("password")).sendKeys("zAsYreg");

		// Click Login button
		driver.findElement(By.name("btnLogin")).click();

		// Assertion to verify login success
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle, "Login Failed!");
	}

	@AfterTest
	public void tearDown() {

		// Close browser
		driver.quit();
	}

}
