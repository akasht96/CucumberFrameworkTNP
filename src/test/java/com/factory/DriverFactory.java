package com.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	static WebDriver driver = null;

	public static WebDriver intializeBrowser(String browser) {

		if (browser == "chrome") {
			driver = new ChromeDriver();
		} else if (browser == "firefox") {
			driver = new FirefoxDriver();
		} else if (browser == "edge") {
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(prop.getProperty("url"));
		driver.get("https://tutorialsninja.com/demo/");
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
