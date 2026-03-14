package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.LoginDataProvider;
import pages.LoginPage;
import utils.ConfigReader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Guru99LoginTest extends BaseTest {

	 @Test
	 public void VerifyLogin() {
	ConfigReader config = new ConfigReader();

    LoginPage loginPage = new LoginPage(driver);

    loginPage.login(
            config.getUsername(),
            config.getPassword());

    String title = driver.getTitle();

    Assert.assertEquals(title, "Guru99 Bank Manager Home");
}

}