package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountBtnOption;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginBtnOption;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerBtnOption;
	
	public void clickOnMyAccountOption() {
		myAccountBtnOption.click();
	}
	
	public LoginPage clickOnLoginOption() {
		loginBtnOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterOption() {
		registerBtnOption.click();
		return new RegisterPage(driver);
	}
}
