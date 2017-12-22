package com.cn.demo.service;



import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.demo.common.logback.LogbackRecord;
import com.cn.demo.service.impl.HackServiceImplA;
import com.cn.demo.util.ThreadPoolUtil;

public class TaskHello {
	private static Logger logger = LoggerFactory.getLogger(TaskHello.class);


//	@Autowired
//	HackAttackService hackAttackService;
//	
//	@Autowired
//	HackServiceImplA hackServiceImplA;
	
	public void sayHello(){
//		HackDo hackDo = null;
		
		String log = "haha,hello World, this is TaskHello, ha ha ha ha ha,^=^^=^^=^^=^^=^";
		logger.info(log);
//		hackDo = hackAttackService;
//		hackDo.doHack(null);
//		hackDo = hackServiceImplA;
//		hackDo.doHack(null);
//		LogbackRecord.getInstance().recordLog(log);
		for(int i=0;i<1500;i++){
			final int index = i;
//			logger.info("submit thread,the thread number is: " + index );
//			LogbackRecord.getInstance().recordLog("submit thread,the thread number is: " + index );
//			ThreadPoolUtil.getInstance().submitTask(new Runnable(){
//
//				public void run() {
//					logger.info("haha,start run thread:" + index + "thread name is :" + Thread.currentThread().getName());
//					LogbackRecord.getInstance().recordLog("haha,start run thread:" + index + "thread name is :" + Thread.currentThread().getName());
//					try {
//						TimeUnit.SECONDS.sleep(2000);;
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					logger.info("haha,end run thread:" + index + "thread name is :" + Thread.currentThread().getName());
//					LogbackRecord.getInstance().recordLog("haha,end run thread:" + index + "thread name is :" + Thread.currentThread().getName());
//				}
//				
//			});
			try {
				ThreadPoolUtil.getInstance().submitTask(new HelloThread());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Ïß³Ì³ØÒì³£:{}",e);
			}
		}
	
	}
}
