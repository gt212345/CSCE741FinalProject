package com.usc.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"json:cucmberOutput/cucumber.json", "html:cucumber.html"},
		features = "Feature",
		plugin = "pretty",
		//tags = {"@url", "@angular"},
		glue = {"com.usc.cucumber"}
		)
public class cucmberTestRunner {

}
