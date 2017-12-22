package com.cn.demo.service;

import java.util.Collection;
import java.util.Iterator;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class MySubcribe {
	
	public static String MY_KEY = "publish_key";
	public static String MY_VALUE = "haha";
	
	public MySubcribe(final ShardedJedisPool shardedJedisPool){
		new Thread(new Runnable(){

			public void run() {
				ShardedJedis sr = shardedJedisPool.getResource();
				Collection<Jedis> coll = sr.getAllShards();
				Iterator<Jedis> it = coll.iterator();
				while(it.hasNext()){
					Jedis js = it.next();
					js.subscribe(new JedisPubSub(){

						@Override
						public void onMessage(String channel, String message) {
							MY_VALUE = message;
							
						}

						@Override
						public void onPMessage(String pattern, String channel, String message) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSubscribe(String channel, int subscribedChannels) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onUnsubscribe(String channel, int subscribedChannels) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onPUnsubscribe(String pattern, int subscribedChannels) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onPSubscribe(String pattern, int subscribedChannels) {
							// TODO Auto-generated method stub
							
						}
						
					}, MY_KEY);
					break;
				}
				
			}
			
		}).start();
	}

}
