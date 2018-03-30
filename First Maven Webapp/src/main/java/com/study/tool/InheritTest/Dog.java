package com.study.tool.InheritTest;

public class Dog extends Animal{
	public Dog(){
		System.out.println("Dog构造方法");
	}
   public void move(){
	   Class<? extends Animal> class1 = getClass();
	   System.out.println("Dog里 getClass()反回:"+class1+"\r\n"
	+"  getClass.getName():"+class1.getName()+"\r\n"
	+"  getClass.getSimpleName():"+class1.getSimpleName());
      System.out.println("狗可以跑和走");
   }
   public void bark(){
      System.out.println("狗可以吠叫");
   }
   public static void main(String args[]){
	   Animal a = new Animal(); // Animal 对象
	   //a.move();// 执行 Animal 类的方法*/
	   Dog b = new Dog(); // Dog 对象
	   /*
	   b.move();//执行 Dog 类的方法
	   b.bark();*/
	   
	   Animal c = b;
	   System.out.println(c.getClass());//c实际引用的是b
	   //返回引用运行时真正所指的对象(因为:子对象的引用可能会赋给父对象的引用变量中)
	   
	}
}
	 
	

