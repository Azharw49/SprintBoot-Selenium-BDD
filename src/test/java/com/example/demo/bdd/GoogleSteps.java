package com.example.demo.bdd;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import com.example.demo.annotations.LazyAutowired;
import com.example.demo.google.GooglePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
public class GoogleSteps {
	
	@LazyAutowired
    private GooglePage googlePage;

	@Given("I am on google home page")
    public void launchSite() {
        this.googlePage.goTo();
    }

	@When("I give the {string} as input")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

	@When("I click on the search keyword")
    public void clickSearch() {
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
    }

	@Then("I should see atleast {int} outputs")
    public void verifyResults(int count) {
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() >= count);
    }

}
