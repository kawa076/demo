package com.cn.demo.template.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.demo.template.RedisDataSource;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

	private static final Logger logger = LoggerFactory.getLogger(RedisDataSourceImpl.class);
	
	@Autowired
    private ShardedJedisPool  shardedJedisPool;
	
	public ShardedJedis getRedisClient() {
		try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            logger.error("getRedisClent error", e);
        }
        return null;
	}

	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}

	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		if(broken){
			shardedJedisPool.returnBrokenResource(shardedJedis);
		}else{
			shardedJedisPool.returnResource(shardedJedis);
		}

	}

}
