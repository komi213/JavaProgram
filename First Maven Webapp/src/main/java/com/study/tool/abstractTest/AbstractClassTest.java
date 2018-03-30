package com.study.tool.abstractTest;

/*
 * 定义一个抽象类，
 * 1.有抽象方法的类肯定是抽象类
 * 2.抽象类可以不定义抽象方法
 * 3.抽象方法没有方法体，由实现类去实现
 * 4.抽象类继承抽象类，可以不用实现，让实现类去实现。
 * 5.抽象类实现接口部分方法，剩下的方法让其它集成类去实现。
 */
public abstract class AbstractClassTest implements Human {
	
	public abstract int size();//自定义的抽象类接口
	public String toString(String s ){//自定义的方法
		return s+";+1";
		
	}
	/**
	 * 实现接口其中微笑方法,剩下给普通类实现
	 */
	@Override
	public void smile() {
		System.out.println("AbstractClassTest抽象类中实现Human接口中的smile()方法");
	}
	
}
