package com.study.tool.abstractTest.impl;

import com.study.tool.abstractTest.Human;

/**
 * 中国人
 * @author komi
 *
 */
public class ChinaHuman implements Human{

	@Override
	public void smile() {
		// TODO Auto-generated method stub
		System.out.println("中国人微笑");
	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("中国人讨论");
	}
	
}
