package com.study.tool.InnerOuterClassTest;

//外部内与内部类测试
public class Outer {
	//非静态内部类
	//Static Nested Class是被声明为静态（static）的内部类，它可以不依赖于外部类实例被实例化。
	//而通常的内部类需要在外部类实例化后才能实例化，其语法看起来挺诡异的，
	//注意：Java中非静态内部类对象的创建要依赖其外部类对象，上面的面试题中foo和main方法都是静态方法，
	//静态方法中没有this，也就是说没有所谓的外部类对象，因此无法创建内部类对象，如果要在静态方法中创建内部类对象，可以这样做：
    //new Outer().new Inner();
	class Inner {}
	public void bar() { new Inner(); }
    public static void foo() { new Outer().new Inner(); }
   
    //静态内部类
    static class Inner2{}
    public void bar2() { new Inner2(); }
    public static void foo2() { new Inner2(); }
    
    public static void main(String[] args) {
    	new Outer().new Inner();//非静态内部类实例化
    	new Inner2();//静态内部类实例化
    }
}
