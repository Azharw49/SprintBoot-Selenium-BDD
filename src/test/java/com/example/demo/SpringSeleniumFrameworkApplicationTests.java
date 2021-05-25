package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.config.FakerConfig;
import com.github.javafaker.Faker;

@SpringBootTest
class SpringSeleniumFrameworkApplicationTests {
  
	@Autowired
	User user;
	
	
	
	@Value("${fruits}")
	private List<String> fruits;
	
	@Value("${name:Kohli}")
	private String name;
	
	
	
	@Test
	void contextLoads() {
		user.getUserDetails();
		System.out.println(fruits);
		System.out.println(name);
		
	}

}
