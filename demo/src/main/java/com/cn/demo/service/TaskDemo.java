package com.cn.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cn.demo.common.logback.LogbackRecord;


public class TaskDemo {
	private static Logger logger = LoggerFactory.getLogger(TaskDemo.class);
	public void run(){
		logger.info("start execute TaskDemo run method");
		LogbackRecord.getInstance().recordLog("start execute TaskDemo run method");
		executeTask();
		logger.info("end execute TaskDemo run method");
		LogbackRecord.getInstance().recordLog("end execute TaskDemo run method");
	}
	
	public void executeTask(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		logger.info("current time is " + sdf.format(date));
		LogbackRecord.getInstance().recordLog("current time is " + sdf.format(date));
	}
}
