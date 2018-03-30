package com.study.tool;

public class Reason {
	public static Integer a = 0;
	static{
		System.out.println("开始static---赋值"+a);
		a = 5;
		System.out.println("结束static---赋值"+a);
	}
	
	public static Integer getA(Integer b){
		
		return a+b;
	}
	public static Integer getA2(Integer c){
		
		return a+c;
	}
	
}
