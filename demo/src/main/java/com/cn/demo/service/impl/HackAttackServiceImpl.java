package com.cn.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cn.demo.service.HackAttackService;

@Service
public class HackAttackServiceImpl implements HackAttackService{
	public static Logger logger = LoggerFactory.getLogger(HackAttackServiceImpl.class);
	@Override
	public <T> void doHack(T obj) {
		// TODO Auto-generated method stub
		logger.info("invoke HackAttackServiceImpl.doHack");
	}

	@Override
	public <T> void attackDns(T obj) {
		// TODO Auto-generated method stub
		
	}




}
