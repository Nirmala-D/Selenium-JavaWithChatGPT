package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class RegisterPage  {
	
	 WebDriver driver;

	    By emailBox =
	            By.xpath("//input[@name='emailid']");

	    By submitBtn =
	            By.xpath("//input[@name='btnLogin']");

	    public RegisterPage(WebDriver driver) {

	        this.driver = driver;
	    }

	    public void enterEmail(String email) {

	        driver.findElement(emailBox)
	                .sendKeys(email);
	    }

	    public void clickSubmit() {

	        driver.findElement(submitBtn)
	                .click();
	    }

}
