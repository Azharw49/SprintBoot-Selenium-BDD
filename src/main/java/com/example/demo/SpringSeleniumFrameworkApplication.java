package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSeleniumFrameworkApplication {

	@Value("${name:Kohli}")
	private String name;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSeleniumFrameworkApplication.class, args);
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println(name);
	}

}
