package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = { "com.stepdefinations", "com.hooks" },
		//tags = "@SC_InvalidLogin",
		publish = true,
		plugin = "pretty"
		)
public class TestRunner {

}
