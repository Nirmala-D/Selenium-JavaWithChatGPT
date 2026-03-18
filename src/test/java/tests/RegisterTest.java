package tests;


import base.BaseTest;
import pages.RegisterPage;
import utils.ConfigReader;

import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
	
	 @Test
	    public void verifyRegister() {

	        ConfigReader config =
	                new ConfigReader();

	        RegisterPage page =
	                new RegisterPage(driver);

	        String email =
	                config.getEmail();

	        page.enterEmail(email);

	        page.clickSubmit();
	    }

}
