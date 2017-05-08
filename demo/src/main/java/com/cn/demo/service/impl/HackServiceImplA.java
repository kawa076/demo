package com.cn.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cn.demo.dao.model.User;

@Service("hackServiceImplA")
public class HackServiceImplA extends HackServiceImpl{
	public static Logger logger = LoggerFactory.getLogger(HackServiceImplA.class);
	@Override
	public <User> void doHack(User obj) {
		
		logger.info("invoke HackServiceImplA.doHack");
	}
}
