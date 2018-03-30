package com.study.tool.Singleton;

public class SingletonTest {
	public static void main(String[] args) {
		//单列，懒汉式(1和2是同一个对象)
		SingletonLazy instance1 = SingletonLazy.getInstance();
		SingletonLazy instance2 = SingletonLazy.getInstance();
		//单列，饿汉式(3和4是同一个对象)
		SingletonHungry instance3 = SingletonHungry.getInstance();
		SingletonHungry instance4 = SingletonHungry.getInstance();
		
	}
}
