package com.example.demo.service;

import java.io.File;
import java.io.IOException;


import java.util.logging.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Lazy
@Service
public class ScreenshotUtil {
	
	private static final Logger log = Logger.getLogger(ScreenshotUtil.class.getName()); 
	
	@Autowired
	ApplicationContext ctx;
	
	@Value("${screenshot.path}")
	String path;
	
	@Autowired
    private Faker faker;
	
	
	public void takeScreenshot() throws IOException
	{
		File SrcFile=ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path+faker.name().firstName()+".png");
		log.info("Screenshot saved in -->"+DestFile.getAbsolutePath());
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
	
	public byte[] getScreenshot()
	{
		return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
	}

}
