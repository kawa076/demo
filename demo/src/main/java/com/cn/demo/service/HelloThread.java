package com.cn.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloThread implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(HelloThread.class);
	public void run() {
		logger.info("thread:" + Thread.currentThread().getName() + "start run");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("thread:" + Thread.currentThread().getName() + "end");
	}

}
