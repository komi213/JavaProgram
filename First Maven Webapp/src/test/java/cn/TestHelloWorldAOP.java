package cn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.service.IHelloWorldService;

@RunWith(SpringJUnit4ClassRunner.class)  //spring环境
@ContextConfiguration(locations={"classpath:spring-aop.xml"})  //加载配置文件环境
public class TestHelloWorldAOP {
	//1.HelloWorldService加@Service注解配合注解扫描<context:component-scan base-package="com.study.service" /> 
	//bean定义在单独的一个xml文件里面，让系统加载配置文件，spring-mybatis.xml里beans前加上<import resource="spring-aop.xml"/>
	//,因为spring-mybaits在web.xml定义成加载配置。
	@Autowired
	IHelloWorldService helloWorld;//在spring运行环境中@Autowired自动把接口实例化对应的实现类
	@Test
    public void selectAllInfo(){  
		//@SuppressWarnings("resource")
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
		//2.spring-aop.xml定义HelloWorldService的bean或者第1种扫描注解的方式的bean
		//IHelloWorldService helloWorld = (IHelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorld.sayChinaHello();
		helloWorld.sayUSAHello();
    }  
}
