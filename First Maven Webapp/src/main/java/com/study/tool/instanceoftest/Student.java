package com.study.tool.instanceoftest;

public class Student extends Person{
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	void init(){
		System.out.println("Student中init()初始化方法");  
	}
	private String name;
	private Integer age;
	public Student() {
		System.out.println("Student类:构造函数");
	}
	public static int X=100;  
    public final static int Y=200;
    static{  
        System.out.println("Student中static语句块执行");  
    }  
    public static void display(){  
        System.out.println("Student中静态方法被执行");  
    }  
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void display_1(){  
        System.out.println("Student中实例方法被执行");  
    }  
	public static void test1(Student student){
		System.out.println("你传的对象参数Class类是："+student.getClass());  
	}
}
