package com.stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Search {

	WebDriver driver;
	private SearchPage searchPage=null;
	@Given("User on the application")
	public void user_on_the_application() {
		driver=DriverFactory.getDriver();
		searchPage=new SearchPage(driver);
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String productName) {
	    searchPage.enterProductNameInSearchBox(productName);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	   searchPage.clickOnSearchBtn();
	}

	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertEquals("valid product not displayed!","HP LP3065", searchPage.getvalidProductDisplayedText());
	    
	}

	@When("User enters Invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String productName) {
		searchPage.enterProductNameInSearchBox(productName);
	}

	@Then("user should get proper warning message about no product matching")
	public void user_should_get_proper_warning_message_about_no_product_matching() {
	
	    Assert.assertTrue("No Product Matches Warning message not displayed!",searchPage.getwarningMessageNoProductMatching().contains("There is no product that matches the search criteria"));
	    
	}

	



}
