package com.example.demo.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.example.demo.annotations.LazyConfiguration;

@LazyConfiguration
public class WedDriverWaitConfig {
	
	@Value("${default.timeout:30}")
	int timeout;
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public WebDriverWait wait(WebDriver driver)
	{
		return new WebDriverWait(driver,timeout);
	}

}
