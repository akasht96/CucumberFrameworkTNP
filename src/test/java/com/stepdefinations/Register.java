package com.stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.AccountSuccessPage;
import com.pages.HomePage;
import com.pages.RegisterPage;
import com.utilities.CommonUtilies;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	@Given("User Navigates to Register account Page")
	public void user_navigates_to_register_account_page() {
	    driver=DriverFactory.getDriver();
	    HomePage homePage=new HomePage(driver);
	    homePage.clickOnMyAccountOption();
	    registerPage = homePage.clickOnRegisterOption();
	}

	@When("User enters a {string} first name")
	public void user_enters_a_first_name(String fname) {
	    registerPage.enterFirstName(fname);
	}

	@When("User enters a {string} last name")
	public void user_enters_a_last_name(String lname) {
		registerPage.enterlastName(lname); 
	}

	@When("User enters a email address")
	public void user_enters_a_email_address() {
		registerPage.enterEmailAddress(CommonUtilies.getEmailTimeStamp()); 
	}
	
	@When("User enters a duplicate {string} email address")
	public void User_enters_a_duplicate_emailAddress_email_address(String duplicateEmail) {
		registerPage.enterEmailAddress(duplicateEmail); 
	}

	@When("User enters a {string} telephone number")
	public void user_enters_a_telephone_number(String telephoneNumber) {
		registerPage.entertelephone(telephoneNumber); 
	}

	@When("User enters a {string} password")
	public void user_enters_a_password(String password) {
		registerPage.enterPassword(password); 
	}

	@When("User enters a {string} confirm password")
	public void user_enters_a_confirm_password(String confirmPassword) {
		registerPage.enterConfirmPassword(confirmPassword); 
	}

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
	    registerPage.acceptPrivacyPolicy();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage=registerPage.clickOnContinueBtn();
	}

	@Then("user account should get created successfully")
	public void user_account_should_get_created_successfully() {
	    Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getuserAccountCreatedSuccessfullyText());
	}

	@When("User select yes for newslater")
	public void user_select_yes_for_newslater() {
	    registerPage.acceptNewsletterOption();
	}

	@Then("user should get a warning about duplicate email")
	public void user_should_get_a_warning_about_duplicate_email() {
	   Assert.assertEquals("Warning: E-Mail Address is already registered!", registerPage.getduplicateEmailWarningText());
	}

	

	@Then("user should get warning messages for every mandatory fields")
	public void user_should_get_warning_messages_for_every_mandatory_fields() {
	   Assert.assertTrue(registerPage.getprivacyPolicyWarningText().contains("Warning: You must agree to the Privacy Policy!"));
	   Assert.assertTrue(registerPage.getfnameWarningText().contains("First Name must be between 1 and 32 characters!"));
	   Assert.assertTrue(registerPage.getlnameWarningText().contains("Last Name must be between 1 and 32 characters!"));
	   Assert.assertTrue(registerPage.getemailWarningText().contains("E-Mail Address does not appear to be valid!"));
	   Assert.assertTrue(registerPage.gettelephoneWarningText().contains("Telephone must be between 3 and 32 characters!"));
	   Assert.assertTrue(registerPage.getpasswordWarningText().contains("Password must be between 4 and 20 characters!"));
	   
	}

	

}
