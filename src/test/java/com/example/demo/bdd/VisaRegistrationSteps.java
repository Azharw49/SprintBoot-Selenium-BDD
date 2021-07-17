package com.example.demo.bdd;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.testng.Assert;

import com.example.demo.visa.VisaRegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisaRegistrationSteps {
	
	@Autowired
	VisaRegistrationPage visaPage;
	
	@Given("I am on Visa homepage")
	public void i_am_on_visa_homepage() {
		visaPage.goTo();
	}
	@When("I enter {string} and {string}")
	public void i_enter_and(String firstName, String lastName) {
		visaPage.enterNames(firstName, lastName);
	}
	@When("I select {string} and {string}")
	public void i_select_and(String from, String to) {
		visaPage.selectCountries(from, to);
	}
	@When("I select {string}")
	public void i_select(String dob) {
		visaPage.selectBirthDate(LocalDate.parse(dob));
	}
	@When("I enter {string}")
	public void i_enter(String email) {
		visaPage.enterEmail(email);
	}
	
	@When("I enter number {string}")
	public void i_enter_number(String phone) {
		visaPage.enterPhoneNumber(phone);
	}
	
	@When("I add {string}")
	public void i_add(String comments) {
		visaPage.addComments(comments);
	}
	@When("I submit the application")
	public void i_submit_the_application() {
		visaPage.submit();
	}
	@Then("the request should not be null")
	public void the_request_should_not_be_null() {
		boolean isEmpty = StringUtils.isEmpty(this.visaPage.getRequestNumber().trim());
				Assert.assertFalse(isEmpty);
	}

}
