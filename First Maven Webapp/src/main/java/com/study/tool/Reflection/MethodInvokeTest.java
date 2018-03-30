package com.study.tool.Reflection;

import java.lang.reflect.Method;

import com.study.tool.instanceoftest.Postgraduate;

public class MethodInvokeTest {
	public static void main(String[] args) throws Exception {
		
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");//过反射调用对象的方法
        System.out.println(m.invoke(str));  // HELLO
        
        Postgraduate pg = new Postgraduate();
        //ReflectionUtil.setValue(sd, "Postgraduate.X", 29);//通过反射给对象的指定字段赋值
        String returnValue = ReflectionUtil.getValue(pg, "X").toString();//通过反射取对象指定字段(属性)的值
        System.out.println(returnValue);
        
    }
}
