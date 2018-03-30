package com.study.tool.InheritTest;

public class Animal{
	
	public Animal(){
		//默认构造函数里面this调用带参的构造函数
		this("komi");//放在构造函数的第一句使用
		System.out.println("Animal构造方法");
	}
	public Animal(String str){
		System.out.println("Animal带参数构造方法,参数:"+str);
	}
   public void move(){
	   Class<? extends Animal> class1 = getClass();
      System.out.println("Animal里 getClass()反回:"+class1);
      System.out.println("动物可以移动");
   }
}
	