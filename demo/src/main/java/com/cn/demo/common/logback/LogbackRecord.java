package com.cn.demo.common.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackRecord {
	private static Logger logger = LoggerFactory.getLogger(LogbackRecord.class);
	private static LogbackRecord instance = new LogbackRecord();
	
	public LogbackRecord(){
		
	}
	public static LogbackRecord getInstance(){
		return instance;
	}
	
	public void recordLog(String logs){
		logger.info(logs, "1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
	}
}
