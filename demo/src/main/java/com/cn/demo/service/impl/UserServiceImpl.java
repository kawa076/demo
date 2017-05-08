package com.cn.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.demo.dao.mapper.UserMapper;
import com.cn.demo.dao.model.User;
import com.cn.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	public static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	public User findUser(User user) {
		logger.info("start userService");
		return userMapper.findUser(user);
	}

}
