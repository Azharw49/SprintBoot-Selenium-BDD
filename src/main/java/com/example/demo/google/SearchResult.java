package com.example.demo.google;

import com.example.demo.annotations.Page;
import com.example.demo.pages.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class SearchResult extends Base {

	@FindBy(tagName = "h3")
	 private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
	public boolean isAt() {
		return this.wait.until((d) -> !this.results.isEmpty());
	}

}
