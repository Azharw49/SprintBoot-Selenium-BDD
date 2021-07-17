package com.example.demo;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		 publish = true
		,features = "classpath:features"
		,glue = "com.example.demo.bdd"
		,plugin = {"json:target/cucumber.json"}
		,monochrome = true,dryRun = false
		 //,tags="@visa"		
		)
public class CucumberRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}
	
	
	

}
