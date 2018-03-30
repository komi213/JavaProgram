package com.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Repository;

/*
 * 定义一个切面类(在spring-aop.xml配置此切面)
 */
@Repository
public class HelloWorldAspect {
	public void beforeAdvice(){
		System.out.println("---前置通知");
	}
	public void afterAdvice(){
		System.out.println("---后置通知");
	}
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("---环绕通知前");
		pjp.proceed();//执行后台方法
		System.out.println("---环绕通知后");
	}
}
