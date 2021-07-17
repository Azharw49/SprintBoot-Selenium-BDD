package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.annotations.Window;
import com.example.demo.service.SwitchWindowService;

@Aspect
@Component
public class WindowAspect {

	
	@Autowired
	SwitchWindowService switchWindowService;
	
	@Before("@target(window) && within(com.example.demo..*)")
	public void before(Window window)
	{
		switchWindowService.switchByTitle(window.value());
	}
	
	@Before("@target(window) && within(com.example.demo..*)")
	public void after(Window window)
	{
		switchWindowService.switchByIndex(0);
	}
}
