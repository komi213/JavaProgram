package com.study.designpattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 李斯这个人，是个观察者，只要韩非子一有动静，这边就知道
 * @author komi
 *
 */
public class LiSi implements Observer {

	@Override
	public void update(Observable o, Object obj) {
		System.out.println("李斯：观察到李斯活动，开始向老板汇报了...");
		this.reportToQiShiHuang(obj.toString());
		System.out.println("李斯：汇报完毕，秦老板赏给他两个萝卜吃吃...\n");
	}
	//汇报给秦始皇
	private void reportToQiShiHuang(String reportContext){
		System.out.println("李斯：报告，秦老板！韩非子有活动了--->"+reportContext);
	}

}
