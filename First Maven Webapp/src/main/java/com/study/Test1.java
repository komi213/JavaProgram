package com.study;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.dao.UserTMapper;
import com.study.model.UserT;

public class Test1 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserTMapper userTMapper = applicationContext.getBean(UserTMapper.class);
		UserT selectById = userTMapper.selectById(1);
		System.out.println(selectById);
		Object o[]={"Rose","India","Net","Limited","Rohini"};
	    Object o1[]={"Rose","India","Net","Limited","Rohini"};
	    //Object o1[]={"Rohini","Limited","Net","India","Rose"};
	    boolean b = Objects.equals(o, o1);
	    System.out.println("Array are equal:-" +b);
	    String v1 = "abc def  d e ";
	    System.out.println(v1);
	    String v2 = StringUtils.isNotBlank(v1)?v1.replace(" ", ""):"";//空格替换
	    System.out.println("V2:"+v2);
	}
}
