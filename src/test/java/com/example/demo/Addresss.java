package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class Addresss {
	
	
	@Value("${street}")
	private String street;
	
	@Autowired
	Faker faker;

	

	public String getAddress() {
		return faker.address().fullAddress();
	}

	public void setAddress(String street) {
		this.street = street;
	}
	
	
	

}
