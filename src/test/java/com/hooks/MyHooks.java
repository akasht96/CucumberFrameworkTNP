package com.hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

	public WebDriver driver;

	@Before
	public void setup() {
		//Properties prop = ConfigReader.initializeProperties();
		driver=DriverFactory.intializeBrowser("chrome");
		//DriverFactory.intializeBrowser(prop.getProperty("browser"));
		
	}

	@After
	public void terdown() {
		driver.quit();
	}
}
