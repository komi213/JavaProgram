package com.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//4种轮询实例
@Controller
public class PollController {
	//1、普通轮询 Ajax方式
	@RequestMapping("poll/page")
	public String page(){
		return "normal_poll";
	}
	
	@RequestMapping("poll/ajax")
	public void ajax(@RequestParam(value="requestTime",required=false) String requestTime,HttpServletResponse response) throws IOException, InterruptedException{
		PrintWriter writer = response.getWriter();
		Random rand = new Random();
		while(true){
			Thread.sleep(300);//休眠300毫秒，模拟业务处理
			int i = rand.nextInt(101);//产生一个0-100之间的随机数
			if(i>50&&i<90){// 如果随机数在70-90之间就视为有效数据，模拟数据发生变化
				long responseTime = System.currentTimeMillis();
				//返回数据信息，请求时间、返回数据时间、耗时
				writer.print("result:"+i+",response time:"+responseTime+",request time:"+requestTime+",use time:"+(responseTime-Long.parseLong(requestTime)));
				break;//跳出循环，返回数据
			}else{// 模拟没有数据变化，将休眠 hold住连接
				Thread.sleep(1300);
			}
		}
	}
	//2、普通轮询 iframe方式
	@RequestMapping("poll/iframe")
	public String iframe(){
		return "normal_poll_iframe";
	}
	//3、长连接iframe方式
	@RequestMapping("poll/long/iframe")
	public String longIframe(){
		return "long_iframe";
	}
	//4、长连接iframe方式，有序
	@RequestMapping("poll/long/iframe2")
	public String longIframe2(){
		return "long_iframe2";
	}
	//5、ajax实现长连接
	@RequestMapping("poll/long/ajax")
	public String longAjax(){
		return "long_ajax";
	}
}
