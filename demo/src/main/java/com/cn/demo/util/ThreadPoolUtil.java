package com.cn.demo.util;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ThreadPoolUtil {
	public static Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);
	
	private  int coreThreadSize;
	private  int maxThreadSize;
	private  int keepAliveTime;
	private  int dequeMaxSize;
	
	private  ThreadPoolExecutor worker = null;
	private static ThreadPoolUtil instance = new ThreadPoolUtil();
	
//	private static class LazyThredPoolHoler{
//		public static ThreadPoolExecutor tpe = new ThreadPoolExecutor(coreThreadSize, maxThreadSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(dequeMaxSize), new ThreadPoolExecutor.CallerRunsPolicy());
//	}
//	
//	public static ThreadPoolExecutor getInstance(){
//		return LazyThredPoolHoler.tpe;
//	}
	public ThreadPoolUtil(){
		
	}
	public static ThreadPoolUtil getInstance(){
		return instance;
	}
	
	public void init(int coreThreadSize, int maxThreadSize, int keepAliveTime, int dequeMaxSize){
		this.coreThreadSize = coreThreadSize;
		this.maxThreadSize = maxThreadSize;
		this.keepAliveTime = keepAliveTime;
		this.dequeMaxSize = dequeMaxSize;
		if(worker == null){
			BlockingDeque<Runnable> deque = new LinkedBlockingDeque<Runnable>(dequeMaxSize);
			worker = new ThreadPoolExecutor(coreThreadSize, maxThreadSize, keepAliveTime, TimeUnit.SECONDS, deque, new ThreadPoolExecutor.CallerRunsPolicy());
			logger.info("thread pool started");
		}
	}
	
	public Future<?> submitTask(Runnable thread){
		if(worker == null){
			init(coreThreadSize, maxThreadSize, keepAliveTime, dequeMaxSize);
		}
		
		try {
			Future<?> future = worker.submit(thread);
			return future;
		} catch (Exception e) {
			logger.error("submit thread error");
			throw new RuntimeException();
		}
	}
	
	public void shutDown(){
		if(worker != null){
			worker.shutdown();
			logger.info("thread pool stop");
		}
	}
}
