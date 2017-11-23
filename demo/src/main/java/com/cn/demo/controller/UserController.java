package com.cn.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.demo.dao.model.User;
import com.cn.demo.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "findUser", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public User findUser(@RequestBody User user){
		logger.info("start invoke usercontroller.finduser");
		return userService.findUser(user);
	}
	
	@RequestMapping(value = "subUser", method = RequestMethod.GET)
	@ResponseBody
	public String subscribUser(){
		logger.info("start invoke usercontroller.subscribUser");
		userService.subUser();
		return "OK";
	}
	
	@RequestMapping(value = "pubUser", method = RequestMethod.GET)
	@ResponseBody
	public String publishUser(){
		logger.info("start invoke usercontroller.publishUser");
		userService.publishUser();
		return "OK";
	}
}
