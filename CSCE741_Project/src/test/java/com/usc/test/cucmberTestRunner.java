package com.usc.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
/*
 * Created by Heiru Wu
 * 2017/12/03
 */
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
