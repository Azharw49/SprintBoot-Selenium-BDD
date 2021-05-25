package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@Autowired
	Salary salary;
	
	@Autowired
	Addresss address;
	
	public void getUserDetails()
	{
		System.out.println(salary.getAmount());
		System.out.println(address.getAddress());
	}

}
