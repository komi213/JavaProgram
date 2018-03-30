package com.study.tool.abstractTest;

public class NomalClassTest extends AbstractClassTest2 implements Human2 {
	public static void main(String[] args) {
		NomalClassTest t1 = new NomalClassTest();
		System.out.println(t1.size());
		System.out.println(t1.toString("2"));
		t1.smile();
		t1.talk();
		t1.eat();
	}

	@Override
	public void talk() {
		System.out.println("NomalClassTest普通类来实现Human接口中的talk()方法");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("NomalClassTest普通类来实现Human2接口中的eat()方法");
	}
}
