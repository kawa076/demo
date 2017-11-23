package com.cn.demo.service.impl;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.demo.dao.mapper.UserMapper;
import com.cn.demo.dao.model.User;
import com.cn.demo.service.UserService;
import com.cn.demo.template.RedisDataSource;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ShardedJedis;

@Service("userService")
public class UserServiceImpl implements UserService {
	public static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	RedisDataSource redisDataSource;
	
	public User findUser(User user) {
		logger.info("start userService");
		
		return userMapper.findUser(user);
	}

	public void subUser() {
		ShardedJedis sr = redisDataSource.getRedisClient();
		Collection<Jedis> coll = sr.getAllShards();
		Iterator<Jedis> it = coll.iterator();
		while(it.hasNext()){
			Jedis js = it.next();
			js.subscribe(new JedisPubSub(){

				@Override
				public void onMessage(String arg0, String arg1) {
					logger.info("onMessage arg0=" + arg0 +",arg1=" + arg1);
					
				}

				@Override
				public void onPMessage(String arg0, String arg1, String arg2) {
					logger.info("onPMessage arg0=" + arg0 +",arg1=" + arg1 +",arg2=" + arg2);
					
				}

				@Override
				public void onPSubscribe(String arg0, int arg1) {
					logger.info("onPSubscribe arg0=" + arg0 +",arg1=" + arg1);
					
				}

				@Override
				public void onPUnsubscribe(String arg0, int arg1) {
					logger.info("onPUnsubscribe arg0=" + arg0 +",arg1=" + arg1);
					
				}

				@Override
				public void onSubscribe(String arg0, int arg1) {
					logger.info("onSubscribe arg0=" + arg0 +",arg1=" + arg1);
					
				}

				@Override
				public void onUnsubscribe(String arg0, int arg1) {
					logger.info("onUnsubscribe arg0=" + arg0 +",arg1=" + arg1);
					
				}
				
			}, "publish_key");
		}
		
	}

	public void publishUser() {
		ShardedJedis sr = redisDataSource.getRedisClient();
		Collection<Jedis> coll = sr.getAllShards();
		Iterator<Jedis> it = coll.iterator();
		while(it.hasNext()){
			Jedis js = it.next();
			logger.info("publish user ....");
			js.publish("publish_key", "haha");
		}
		
	}

}
