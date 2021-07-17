package com.example.demo.bdd;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.example.demo.annotations.LazyAutowired;
import com.example.demo.service.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class CucumberHooks {
	
	Logger LOG = LoggerFactory.getLogger(CucumberHooks.class);

    @LazyAutowired
    private ScreenshotUtil screenshotService;
    
    @Autowired
    ApplicationContext ctx;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
        	LOG.error("Scenario : {} is failed",scenario.getName());
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
        
        this.ctx.getBean(WebDriver.class).quit();
    }
    
    


}
