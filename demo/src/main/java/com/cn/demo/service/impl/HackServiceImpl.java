package com.cn.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cn.demo.service.HackService;

@Service("hackService")
public class HackServiceImpl implements HackService{
	public static Logger logger = LoggerFactory.getLogger(HackServiceImpl.class);
	public <T> void doHack(T obj) {
		
		logger.info("invoke HackServiceImpl.doHack");
	}

	public List<?> getSecretInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void damageDevice() {
		// TODO Auto-generated method stub
		
	}

}
