package com.study.tool.Listener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
会话监听器，在用户会话创建和销毁的时候根据情况
修改onLineCount和maxOnLineCount的值

*/
@WebListener//这里使用了Servlet 3规范中的@WebListener注解配置监听器，当然你可以在web.xml文件中用<listener>标签配置监听器
public class MaxCountListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		ServletContext ctx = event.getSession().getServletContext();
		int count = Integer.parseInt(ctx.getAttribute("onLineCount").toString());
		count++;
		ctx.setAttribute("onLineCount", count);
		int maxOnLineCount = Integer.parseInt(ctx.getAttribute("maxOnLineCount").toString());
		if(count> maxOnLineCount){
			maxOnLineCount = count;
			ctx.setAttribute("maxOnLineCount", maxOnLineCount);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ctx.setAttribute("date", df.format(new Date()));
		}
		//当前时间
		Date nowDate = Calendar.getInstance().getTime();
		event.getSession().setAttribute("createDate", nowDate);
		System.out.println("创建Session时,在线数量:"+count+",最大量："+maxOnLineCount);
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss,SSS");//web.xml配置session过期时间1分钟
		System.out.println(df.format(nowDate));
		event.getSession().setMaxInactiveInterval(10);//代码设置session过期时间优先级>web.xml>tomcat下的server.xml
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		ServletContext app = event.getSession().getServletContext();
		int count = Integer.parseInt(app.getAttribute("onLineCount").toString());
		count--;
		app.setAttribute("onLineCount", count);
		System.out.println("关闭Session时在线数量:"+count);
		
		//当前时间
		Date nowDate = Calendar.getInstance().getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss,SSS");
		System.out.println(df.format(nowDate));
		Date createDate = (Date) event.getSession().getAttribute("createDate");
		long a = nowDate.getTime()-createDate.getTime();
		System.out.println(a);
	}
	
}
