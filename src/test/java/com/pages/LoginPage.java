package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement credentialsMismatchedWarningText;

	public void enterEmailAddress(String emailAddress) {
		emailField.sendKeys(emailAddress);
	}

	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}

	public AccountPage clickOnLoginBtn() {
		loginBtn.click();
		return new AccountPage(driver);
				
	}
	
	public String getcredentialsMismatchedWarningText() {
		return credentialsMismatchedWarningText.getText();
	}

}
