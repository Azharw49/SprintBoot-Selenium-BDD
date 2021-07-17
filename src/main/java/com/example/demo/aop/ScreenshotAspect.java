package com.example.demo.aop;

import java.io.IOException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.annotations.TakeScreenshot;
import com.example.demo.service.ScreenshotUtil;

@Aspect
@Component
public class ScreenshotAspect {
	
	@Autowired
	ScreenshotUtil screenshot;
	
	
	@After("@annotation(takeScreenshot)")
	public void after(TakeScreenshot takeScreenshot) throws IOException
	{
		screenshot.takeScreenshot();
	}

}
