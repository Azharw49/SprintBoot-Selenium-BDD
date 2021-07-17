package com.example.demo.config;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import com.example.demo.annotations.LazyConfiguration;
import com.example.demo.annotations.ThreadScope;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {
	
	
	@Value("${selenium.grid.url}")
	private URL url;
	
	@ThreadScope
	@ConditionalOnProperty(name = "browser" , havingValue = "firefox")
	public WebDriver remoteFirefoxDriver()
	{
		return new RemoteWebDriver(url, DesiredCapabilities.firefox());
	}
	
	@ThreadScope
	@ConditionalOnMissingBean
	public WebDriver chromeFirefoxDriver()
	{
		return new RemoteWebDriver(url, DesiredCapabilities.chrome());
	}

}
