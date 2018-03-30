package com.study.tool.Log4j;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class LoggerTest {
	public static void main(String[] args) {
		/*日志级别(低于设置级别的不会被打印出来):
		每个Logger都被了一个日志级别（log level），用来控制日志信息的输出。日志级别从高到低分为：
		A：off         最高等级，用于关闭所有日志记录。
		B：fatal       指出每个严重的错误事件将会导致应用程序的退出。
		C：error      指出虽然发生错误事件，但仍然不影响系统的继续运行。
		D：warm     表明会出现潜在的错误情形。
		E：info         一般和在粗粒度级别上，强调应用程序的运行全程。
		F：debug     一般用于细粒度级别上，对调试应用程序非常有帮助。
		G：all           最低等级，用于打开所有日志记录。*/
		Logger logger = Logger.getLogger(LoggerTest.class);
		SimpleLayout layout = new SimpleLayout();
		
		FileAppender appender = null;
	    try
	    {
	        //把输出端配置到out.txt
	        appender = new FileAppender(layout,"out.txt",false);
	    }catch(Exception e){   
	    	e.printStackTrace();
	    }
	    
	    logger.addAppender(appender);//添加输出端
	    logger.setLevel((Level)Level.ERROR);//覆盖配置文件中的级别
	    logger.debug("debug");
	    logger.info("info");
	    logger.warn("warn");
	    logger.error("error");
	    logger.fatal("fatal");
	}
}
