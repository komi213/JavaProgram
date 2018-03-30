package com.study.tool.AnnotationTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Temp temp = new Temp();
		Method method = temp.getClass().getMethod("test");
		Method method2 = temp.getClass().getMethod("test2",String.class);//方法带参数的
		
		//是否存在这个注解
		System.out.println(method.isAnnotationPresent(GetView.class));
		//就是调用类中的方法，最简单的用法是可以把方法参数化
		method.invoke(temp);//调用temp对象的方法(方法不带参数)
		method2.invoke(temp,"komi");//调用temp对象的方法(方法带参数)
		GetView gv = method.getAnnotation(GetView.class);
		
		if(gv!=null){
			System.out.println("有注解");
			System.out.println(gv.Method());
			System.out.println(gv.Value());
		}else{
			
			System.out.println("没有注解");
		}
	}
}
