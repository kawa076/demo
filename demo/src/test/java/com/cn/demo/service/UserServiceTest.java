package com.cn.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.demo.dao.model.User;

@RunWith(SpringJUnit4ClassRunner.class)     //��ʾ�̳���SpringJUnit4ClassRunner��  
@ContextConfiguration(locations = {"classpath:config/spring-*.xml"}) 
public class UserServiceTest {
	public static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void findUserTest(){
		User u = new User();
		u.setUsername("zhang");
		User uu = userService.findUser(u);
		logger.info("���Ϊ" + uu.toString());
	}
}
