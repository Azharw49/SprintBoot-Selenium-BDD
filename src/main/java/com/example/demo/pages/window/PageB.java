package com.example.demo.pages.window;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.demo.annotations.Page;
import com.example.demo.annotations.Window;
import com.example.demo.pages.Base;

@Window("Page B")
public class PageB extends Base{
	
	@FindBy(id = "area")
	private WebElement textArea;
	
	public void addText(String text)
	{
		this.textArea.sendKeys(text);
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		return wait.until(d -> textArea.isDisplayed());
	}

}
