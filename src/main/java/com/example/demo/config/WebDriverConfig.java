package com.example.demo.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.example.demo.annotations.LazyConfiguration;
import com.example.demo.annotations.ThreadScope;

import io.github.bonigarcia.wdm.WebDriverManager;


@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

	@ThreadScope
	@ConditionalOnProperty(name = "browser" , havingValue = "firefox")
	public WebDriver firefoxDriver()
	{
	 WebDriverManager.firefoxdriver().version("0.29.1").setup();
	 return new FirefoxDriver();
	}
	
	@ThreadScope
	@ConditionalOnMissingBean
	public WebDriver chromeDriver()
	{
	 WebDriverManager.chromedriver().version("90.0.4430.24").setup();
	 return new ChromeDriver();
	}
	
	
	
	

}
