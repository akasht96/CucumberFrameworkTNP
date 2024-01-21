package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement fnameField;
	@FindBy(id = "input-lastname")
	private WebElement lnameField;
	@FindBy(id = "input-email")
	private WebElement emailIdField;
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	@FindBy(id = "input-password")
	private WebElement passwordField;
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyField;
	@FindBy(xpath = "//label[@class='radio-inline'][1]/child::input")
	private WebElement newsLetterField;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarningText;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningText;
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement fnameWarningText;
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lnameWarningText;
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningText;
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningText;
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningText;
	

	public String getduplicateEmailWarningText() {
		return duplicateEmailWarningText.getText();
	}
	
	

	public String getprivacyPolicyWarningText() {
		return privacyPolicyWarningText.getText();
	}

	public String getfnameWarningText() {
		return fnameWarningText.getText();
	}

	public String getlnameWarningText() {
		return lnameWarningText.getText();
	}

	public String getemailWarningText() {
		return emailWarningText.getText();
	}

	public String gettelephoneWarningText() {
		return telephoneWarningText.getText();
	}

	public String getpasswordWarningText() {
		return passwordWarningText.getText();
	}

	public void enterFirstName(String fname) {
		fnameField.sendKeys(fname);
	}

	public void enterlastName(String lname) {
		lnameField.sendKeys(lname);
	}

	public void enterEmailAddress(String emailAddress) {
		emailIdField.sendKeys(emailAddress);
	}

	public void entertelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}

	public void enterPassword(String pwd) {
		passwordField.sendKeys(pwd);
	}

	public void enterConfirmPassword(String confirmPwd) {
		confirmPasswordField.sendKeys(confirmPwd);
	}

	public void acceptPrivacyPolicy() {
		privacyPolicyField.click();
	}

	public void acceptNewsletterOption() {
		newsLetterField.click();
	}

	public AccountSuccessPage clickOnContinueBtn() {
		continueBtn.click();
		return new AccountSuccessPage(driver);
	}
}
