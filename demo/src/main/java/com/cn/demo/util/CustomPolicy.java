package com.cn.demo.util;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomPolicy implements RejectedExecutionHandler{
	private static Logger logger = LoggerFactory.getLogger(CustomPolicy.class);
	
	
	public CustomPolicy(){}
	
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		logger.info("Thread:"+r.toString() +"throw from pool:"+executor.toString());
		
	}

}
