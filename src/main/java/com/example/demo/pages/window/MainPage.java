package com.example.demo.pages.window;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.example.demo.annotations.Page;
import com.example.demo.annotations.TakeScreenshot;
import com.example.demo.pages.Base;

@Page
public class MainPage extends Base{
	
	@FindBy(tagName = "a")
	private List<WebElement> links;
	
	@TakeScreenshot
	public void goTo()
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
		this.driver.manage().window().maximize();
	}
	
	public void clickAllinks() throws InterruptedException
	{
		
			for (int i = 0; i < links.size(); i++) {
	            links.get(i).click();
	            Thread.sleep(1000);
	            this.wait.until(ExpectedConditions.numberOfWindowsToBe(i + 2));
	        }
		
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		return wait.until(d -> !this.links.isEmpty());
	}

}
