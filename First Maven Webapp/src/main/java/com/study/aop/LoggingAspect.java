package com.study.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

/*
 * 通过注解的方式定义切面类
 */
	/*execution(public * com.sample.service.impl..*.*(..))
	解释如下：
	符号	含义
	execution（）
	表达式的主体；
	public:指定public修饰的方法,不写匹配所有修饰的方法
	第一个”*“符号:表示返回值的类型任意；
	com.sample.service.impl	AOP所切的服务的包名，即，我们的业务部分
	包名后面的”..“	表示当前包及子包
	第二个”*“	表示类名，*即所有类。此处可以自定义，下文有举例
	.*(..)	表示任何方法名，括号表示参数，两个点表示任何参数类型
	在类名模式串中，“.*”表示包下的所有类，而“..*”表示包、子孙包下的所有类。
	*/

@Aspect  //这个类声明为一个切面(spring-aop.xml配置加这个<aop:aspectj-autoproxy></aop:aspectj-autoproxy>)
@Repository  //需要把该类放入到IOC容器中
public class LoggingAspect {
	//声明该方法是一个前置通知：在目标方法开始之前执行
	@Before("execution(* com.study..*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("前置通知@Aspect注解方式：The method " + methodName + " begin with " + args);
	}
	
	//后置通知：在目标方法执行后（无论是否发生异常），执行的通知
	@After("execution(* com.study..*.*(..))")
	public void afterAdvice(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("后置通知@Aspect注解方式：The method " + methodName + " end with " + args);
	}
	
}
