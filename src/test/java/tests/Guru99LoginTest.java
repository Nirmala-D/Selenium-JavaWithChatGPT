package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class Guru99LoginTest extends BaseTest {
	
	 @Test
	 public void VerifyLogin() {
	ConfigReader config = new ConfigReader();

    LoginPage loginPage = new LoginPage(driver);

    loginPage.login(
            config.getUsername(),
            config.getPassword());

    String title = driver.getTitle();

    Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
}

}
