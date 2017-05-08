package com.cn.demo.service;

import java.util.List;

public interface HackService extends HackDo{

	public List<?> getSecretInfo();
	
	public void damageDevice();
}
