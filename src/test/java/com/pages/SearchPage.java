package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement serachInputBox;
	@FindBy(xpath = "//span[@class='input-group-btn']/child::button")
	private WebElement searchBtn;
	@FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
	private WebElement validProductDisplayedText;
	@FindBy(xpath = "//div[@id='content']/child::p[2]")
	private WebElement warningMessageNoProductMatching;
	
	public void enterProductNameInSearchBox(String productName) {
		serachInputBox.sendKeys(productName);
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	
	public String getvalidProductDisplayedText() {
		return validProductDisplayedText.getText();
	}
	
	public String getwarningMessageNoProductMatching() {
		return warningMessageNoProductMatching.getText();
	}
}
