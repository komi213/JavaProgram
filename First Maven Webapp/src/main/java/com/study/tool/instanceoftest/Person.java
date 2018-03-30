package com.study.tool.instanceoftest;

public class Person {
	public Person() {
		System.out.println("Person类:构造函数");
	}
	public static int X=100;  
    public final static int Y=200;
    static{  
        System.out.println("Person中static语句块1执行");  
    }  
    public static void display(){  
        System.out.println("Person中静态方法被执行");  
    }  
    public void display_1(){  
        System.out.println("Person中实例方法被执行");  
    }  
    static{  
        System.out.println("Person中static语句块2执行");  
    }  
}
