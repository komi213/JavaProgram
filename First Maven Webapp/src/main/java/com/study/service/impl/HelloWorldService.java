package com.study.service.impl;

import org.springframework.stereotype.Repository;

import com.study.service.IHelloWorldService;

/**
 * 用来测试spring aop
 * @author komi
 *
 */
@Repository
public class HelloWorldService implements IHelloWorldService {

	@Override
	public void sayChinaHello() {
		// TODO Auto-generated method stub
		System.out.println("Spring AOP 你好 China");
	}

	@Override
	public void sayUSAHello() {
		// TODO Auto-generated method stub
		System.out.println("Spring AOP 你好 USA");
	}

}
