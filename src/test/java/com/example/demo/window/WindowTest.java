package com.example.demo.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.demo.SpringBaseTestNGTest;
import com.example.demo.SpringSeleniumFrameworkApplication;
import com.example.demo.pages.window.MainPage;
import com.example.demo.pages.window.PageA;
import com.example.demo.pages.window.PageB;
import com.example.demo.pages.window.PageC;
import com.example.demo.service.SwitchWindowService;

@ComponentScan(basePackages = "com.example.demo.*")
@TestPropertySource(properties = "browser = chrome")
public class WindowTest extends SpringBaseTestNGTest {
	
	@Autowired
	MainPage mainPage;
	 
	@Autowired
	PageA pageA;
	
	@Autowired
	PageB pageB;
	
	@Autowired
	PageC pageC;
	
	
	@BeforeClass
	public void openBrowser() throws InterruptedException
	{
		this.mainPage.goTo();
		this.mainPage.isAt();
		this.mainPage.clickAllinks();
	}
	
	
	@Test(dataProvider = "getData")
	public void test(int index)
	{
		
		this.pageA.addText(String.valueOf(index) + "\n");
		this.pageC.addText(String.valueOf(index * 2) + "\n");
		this.pageB.addText(String.valueOf(index * 3) + "\n");
	}
	
	@DataProvider
	public Object[] getData()
	{
		return new Object []
				{
						1,
						2,
						3,
						4,
						5
				};
	}

}
