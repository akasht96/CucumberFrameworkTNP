package com.stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.AccountPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.CommonUtilies;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {

	WebDriver driver;
	private LoginPage loginPage=null;
	private AccountPage accountPage=null;
	@Given("User Navigates to login Page")
	public void User_Navigates_to_login_Page() {
		driver = DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccountOption();
		loginPage=homePage.clickOnLoginOption();
	}

	@When("^User has entered a valid emailaddress (.+) into email field$")
	public void user_has_entered_a_valid_emailaddress_into_email_field(String emailAddress) {
		loginPage.enterEmailAddress(emailAddress);
	}

	@When("^User has entered a valid password (.+) into password field$")
	public void user_has_entered_a_valid_password_into_password_field(String password) {
		loginPage.enterpassword(password);
	}

	@When("User Clicked on login button")
	public void user_clicked_on_login_button() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		accountPage=loginPage.clickOnLoginBtn();
	}

	@Then("User Should get successfully loged in")
	public void user_should_get_successfully_loged_in() {
		
		Assert.assertTrue("Login Failed!", accountPage.checkVisibilityOfEditYourAccountInfoLink());
		
	}

	@When("User has entered a Invalid emailaddress into email field")
	public void user_has_entered_a_invalid_emailaddress_into_email_field() {
		loginPage.enterEmailAddress(CommonUtilies.getEmailTimeStamp());
	}

	@When("User has entered a Invalid password {string} into password field")
	public void user_has_entered_a_invalid_password_into_password_field(String Invalidpassword) {
		loginPage.enterpassword(Invalidpassword);
	}

	@Then("User Should get a proper warning message credentials mismatched")
	public void user_should_get_a_proper_warning_message_credentials_mismatched() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		String expectedText = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue("Error in receiving Credentials Mismatched warning message", loginPage.getcredentialsMismatchedWarningText().contains(expectedText));
	}

	
}
