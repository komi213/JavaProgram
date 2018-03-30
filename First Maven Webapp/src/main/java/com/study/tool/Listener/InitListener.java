package com.study.tool.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//下面是一个统计网站最多在线人数监听器的例子。
@WebListener//这里使用了Servlet 3规范中的@WebListener注解配置监听器，当然你可以在web.xml文件中用<listener>标签配置监听器
public class InitListener implements ServletContextListener  {
	/**
	 上下文监听器，在服务器启动时初始化onLineCount和maxOnLineCount两个变量
	 并将其置于服务器上下文（ServletContext）中，其初始值都是0
	*/
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("上下文：销毁方法contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getServletContext().setAttribute("onLineCount", 0);
		arg0.getServletContext().setAttribute("maxOnLineCount", 0);
		System.out.println("上下文：初始方法contextInitialized");
	}

}
