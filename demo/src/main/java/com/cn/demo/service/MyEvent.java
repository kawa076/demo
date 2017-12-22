package com.cn.demo.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyEvent implements ApplicationContextAware{
	

	private static ApplicationContext ctx;
	

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		MyEvent.ctx = arg0;
		
	}

}
