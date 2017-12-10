package com.usc.cucumber;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTest {
	WebDriver driver;
	String url = "";
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^User is on homepage$")
	public void user_is_on_homepage() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");
	}

	@When("^User click the get all department button$")
	public void user_click_the_get_all_department_button() throws Throwable {
		driver.get("http://localhost:4200/getAllDep");
	}

	@Then("^webpage display correct department information \\[\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\\]$")
	public void webpage_display_correct_department_information(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7) throws Throwable {
		WebElement output = driver.findElement(By.xpath("/html/body/pre"));
		String[] array = output.getText().substring(2, output.getText().length() - 2).split("\",\"");
		StringBuilder stringBuilder = new StringBuilder();
		for (String s : array) {
			stringBuilder.append(s);
		}
		scenario.write("tmp" + stringBuilder.toString());
		scenario.write("arg" + arg1 + arg2 + arg3 + arg4 + arg5 + arg6 + arg7);
		if (stringBuilder.toString().equals(arg1 + arg2 + arg3 + arg4 + arg5 + arg6 + arg7)) {
			System.out.println(output.getText());
		} else {
			driver.quit();
			fail();
		}
		driver.quit();
	}

	@When("^User click the get all instructor for a specfic department button$")
	public void user_click_the_get_all_instructor_for_a_specfic_department_button() throws Throwable {
		url += "http://localhost:4200/getInstByDept/";
	}

	@Then("^The system ask for department input \"([^\"]*)\"$")
	public void the_system_ask_for_department_input(String arg1) throws Throwable {
		url += arg1;
		driver.get(url);
	}

	@And("^webpage display correct instructor information \\[\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\\]$")
	public void webpage_display_correct_instructor_information(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12,
			String arg13, String arg14) throws Throwable {
		WebElement output = driver.findElement(By.xpath("/html/body/pre"));
		String[] array = output.getText().substring(2, output.getText().length() - 2).split("\",\"");
		StringBuilder stringBuilder = new StringBuilder();
		for (String s : array) {
			stringBuilder.append(s);
		}
		if (stringBuilder.toString().equals(
				arg1 + arg2 + arg3 + arg4 + arg5 + arg6 + arg7 + arg8 + arg9 + arg10 + arg11 + arg12 + arg13 + arg14)) {
			System.out.println(output.getText());
		} else {
			driver.quit();
			fail();
		}
		driver.quit();
	}

	@And("^webpage display correct instructor information \\[\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\\]$")
	public void webpage_display_correct_instructor_information(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12,
			String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19,
			String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26,
			String arg27) throws Throwable {
		WebElement output = driver.findElement(By.xpath("/html/body/pre"));
		String[] array = output.getText().substring(2, output.getText().length() - 2).split("\",\"");
		StringBuilder stringBuilder = new StringBuilder();
		for (String s : array) {
			stringBuilder.append(s);
		}
		if (stringBuilder.toString()
				.equals(arg1 + arg2 + arg3 + arg4 + arg5 + arg6 + arg7 + arg8 + arg9 + arg10 + arg11 + arg12 + arg13
						+ arg14 + arg15 + arg16 + arg17 + arg18 + arg19 + arg20 + arg21 + arg22 + arg23 + arg24 + arg25
						+ arg26 + arg27)) {
			System.out.println(output.getText());
		} else {
			driver.quit();
			fail();
		}
		driver.quit();
	}

	@Given("^I want log in to the system$")
	public void i_want_log_in_to_the_system() throws Throwable {
		driver = new ChromeDriver();
	}

	@When("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		driver.get("http://localhost:4200/");
	}

	@Then("^I try to log in with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_try_to_log_in_with_admin_and_admin(String arg1, String arg2) throws Throwable {
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"fullPage\"]/app-login-form/form/div[1]/input"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"fullPage\"]/app-login-form/form/div[2]/input"));
		userName.sendKeys(arg1);
		password.sendKeys(arg2);
		driver.findElement(By.xpath("//*[@id=\"fullPage\"]/app-login-form/form/div[3]/input")).click();
	}

	@Then("^The system return correct page with url \"([^\"]*)\"$")
	public void the_system_return_correct_page_with_url(String arg1) throws Throwable {
		String url = driver.getCurrentUrl();
		if (url.equals(arg1)) {
			System.out.println(url);
		} else {
			driver.quit();
			fail();
		}
	}
}
