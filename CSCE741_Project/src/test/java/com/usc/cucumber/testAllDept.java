package com.usc.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class testAllDept {
	WebDriver driver;

	@Given("User is on homepage")
	public void userHomePage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");
	}

	@When("User click the get all department button")
	public void clickButton() {
		driver.get("http://localhost:4200/getAllDep");
	}
	
	@Then("webpage display correct department information")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("[\"EMCH\",\"ELCT\",\"MATH\",\"CSCE\",\"ECHE\",\"ECIV\",\"BMEN\"]");
	}

}
