package com.study.tool.instanceoftest;


import org.springframework.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class InstanceofTester {
	public static void main(String[] args) {
		//1.测试子类与父类实例化执行过程,看输出 
		//2.测试instanceof
		//Person p = new Student();
		//instanceofTest(p);
		/*3.前面Person p = new Student();让Person和Student中static语句块儿，执行了一次,后面再实例不会再执行static语句块了。
		称为static代码块 ,也叫静态代码块，是在类中独立于类成员的static语句块，可以有多个，位置可以随便放，
		它不在任何的方法体内，JVM加载类时会执行这些静态的代码块，如果static代码块有多个，
		JVM将按照它们在类中出现的先后顺序依次执行它们，每个代码块只会被执行一次利用静态代码块可以对一些static变量进行赋值*/
		Postgraduate s = new Postgraduate();
		s.setAge(59);
		s.setName("komi");
		s.setDegree("博士后");
		System.out.println(s.toString());
		//instanceofTest(s);
		
		/*4.测试Class.forName()
		Class.forName(xxx.xx.xx) 返回的是一个类, .newInstance() 后才创建一个对象,
		Class.forName(xxx.xx.xx);的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段(只执行一次)*/
		/*try {
			Class.forName("com.study.tool.instanceoftest.Postgraduate");
			Student pd = (Postgraduate) Class.forName("com.study.tool.instanceoftest.Postgraduate").newInstance();
			pd.display_1();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		ArrayList<Student> studentListSrc=new ArrayList<Student>();

		studentListSrc.add(new Student());
		studentListSrc.add(new Student());

		Student set = studentListSrc.set(1, null);

		ListIterator<Student> studentListIterator = studentListSrc.listIterator();
		while (studentListIterator.hasNext()){
			System.out.println(studentListIterator.next());
		}


		//ArrayList<Student> studentListDest=new ArrayList<Student>();
		//Collections.addAll(studentListDest,  new Object[3]);
		//Collections.copy(studentListDest,studentListSrc);

		Student[] students = new Student[3];
		//Object[] obj = new Object[3];
		//obj[2]=3;
		//obj[3]=4;

		int cd = 5;

	}
	public static void instanceofTest(Person p){
		//Person类所在的继承树是：Object<--Person<--Student<--Postgraduate。
		//根据数层级关系来判断
		//判断p的真正的类型
		if(p instanceof Postgraduate){
			System.out.println("此对象是类Postgraduate实例");
		}else if(p instanceof Student){
			System.out.println("此对象是类Student的实例");
		}else if(p instanceof Person){
			System.out.println("此对象是类Person的实例");
		}else if(p instanceof Object){
			System.out.println("此对象是类Object的实例");
		}
		
		 /*if(p instanceof Animal){//此错编译错误，所以做注释
		   System.out.println("p是类Animal的实例");
		 }*/
		/*这个程序的输出结果是：p是类Student的实例
		Person类所在的继承树是：Object<--Person<--Student<--Postgraduate。
		这个例子中还加入一个Animal类，它不是在Person类的继承树中，所以不能作为instanceof的右操作数。*/
	}
}
