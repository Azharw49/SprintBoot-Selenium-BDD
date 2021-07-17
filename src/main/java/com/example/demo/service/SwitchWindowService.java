package com.example.demo.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SwitchWindowService {
	
	@Autowired
	ApplicationContext ctx;
	
	public void switchByTitle(String title)
	{
		 WebDriver driver = this.ctx.getBean(WebDriver.class);
	        driver.getWindowHandles()
	                .stream()
	                .map(handle -> driver.switchTo().window(handle).getTitle())
	                .filter(t -> t.startsWith(title))
	                .findFirst()
	                .orElseThrow(() -> {
	                    throw new RuntimeException("No such window");
	                }
	                );
		     
		     
	}
	
	public void switchByIndex(int index)
	{
		WebDriver driver = this.ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
		     
	}
		

}
