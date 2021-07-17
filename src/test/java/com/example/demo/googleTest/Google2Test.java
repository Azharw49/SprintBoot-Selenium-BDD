package com.example.demo.googleTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.demo.SpringBaseTestNGTest;
import com.example.demo.annotations.LazyAutowired;
import com.example.demo.google.GooglePage;
import com.example.demo.service.ScreenshotUtil;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotUtil screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 25);
        this.screenshotService.takeScreenshot();
        this.googlePage.close();
    }

}
