package com.example.demo.visa;

import java.time.LocalDate;
import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.annotations.Page;
import com.example.demo.pages.Base;

@Page
public class VisaRegistrationPage extends Base {
	
	Logger LOG = LoggerFactory.getLogger(VisaRegistrationPage.class);

	@FindBy(id="first_4")
	private WebElement firstName;
	
	@FindBy(id="last_4")
	private WebElement lastName;
	
	@FindBy(id="input_46")
	private WebElement fromCountry;
	
	@FindBy(id="input_47")
	private WebElement toCountry;
	
	@FindBy(id="input_24_month")
	private WebElement month;
	
	@FindBy(id="input_24_day")
	private WebElement day;
	
	@FindBy(id="input_24_year")
	private WebElement year;
	
	@FindBy(id="input_6")
	private WebElement email;
	
	@FindBy(id="input_27_phone")
	private WebElement phone;
	
	@FindBy(id="input_45")
	private WebElement comments;
	
	@FindBy(id="submitBtn")
	private WebElement submit;
	
	@FindBy(id="requestnumber")
	private WebElement requestNumber;
	
	public void enterNames(String firstName, String lastName)
	{
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		LOG.info("entered first name : {} and last name ; {}",firstName,lastName);
	}
	
	public void selectCountries(String from,String to)
	{
		new Select(this.fromCountry).selectByValue(from);
		new Select(this.toCountry).selectByValue(to);
		LOG.info("Countries are selected : {} , {}",from,to);
	}
	
	public void selectBirthDate(LocalDate date)
	{
		new Select(this.month).selectByValue(String.valueOf(date.getMonth()));
		new Select(this.day).selectByValue(String.valueOf(date.getDayOfMonth()));
		new Select(this.year).selectByValue(String.valueOf(date.getYear()));
		LOG.info("Birth date is selected : {}",date);
	}
	
	public void enterEmail(String email)
	{
		this.email.sendKeys(email);
		LOG.info("Birth date is given : {}",email);
	}
	
	public void enterPhoneNumber(String number)
	{
		this.phone.sendKeys(number);
		LOG.info("Phone Number is given : {}",number);
	}
	
	public void addComments(String comments)
	{
		this.comments.sendKeys(Objects.toString(comments,""));
		LOG.info("Comment is given : {}",comments);
	}
	
	public void submit()
	{
		this.submit.click();
		LOG.info("Clicked Submit");
	}
	
	public String getRequestNumber()
	{
		this.wait.until(d -> this.requestNumber.isDisplayed());
		LOG.warn("waiting for the request number");
		return this.requestNumber.getText();
		
	}
	
	public void goTo()
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
		this.driver.manage().window().maximize();
		LOG.info("The url {} is opened","ttps://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
	}
	
	public void closeBrowser()
	{	
		LOG.info("Quitting Driver");
		this.driver.quit();
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		return wait.until(d -> this.firstName.isDisplayed());
	}
	
	
	
}
