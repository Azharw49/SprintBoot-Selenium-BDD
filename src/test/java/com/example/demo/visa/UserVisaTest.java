package com.example.demo.visa;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.demo.SpringBaseTestNGTest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class UserVisaTest extends SpringBaseTestNGTest{
	
	Logger LOG = LoggerFactory.getLogger(UserVisaTest.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VisaRegistrationPage visaPage;
	
	@Test(dataProvider = "getData")
	public void test(User u)
	{
		visaPage.goTo();
		visaPage.enterNames(u.getFirstName(), u.getLastName());
		visaPage.selectCountries(u.getFromCountry(), u.getToCountry());
		visaPage.selectBirthDate(u.getDob().toLocalDate());
		visaPage.enterEmail(u.getEmail());
		visaPage.enterPhoneNumber(u.getPhone());
		visaPage.addComments(u.getComments());
		visaPage.submit();
		LOG.info("Request Number : {}",visaPage.getRequestNumber());
		   
		
	}
	
	@Test
	public void test2()
	{
		System.out.println(this.userRepository.findFirstNameByLastName("Wiza"));
	}
	
	@DataProvider
	public Object[] getData()
	{
		return this.userRepository.findAll()
				.stream()
				.limit(3)
				.toArray();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		visaPage.closeBrowser();
	}
	
	

}
