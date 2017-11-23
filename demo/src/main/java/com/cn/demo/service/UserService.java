package com.cn.demo.service;

import com.cn.demo.dao.model.User;

public interface UserService {
	public User findUser(User user);
	
	public void subUser();
	
	public void publishUser();
}
