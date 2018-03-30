package com.study.tool.AnnotationTest;

public class Temp {
	public void test2(String name) {
		System.out.println("In test2 method.姓名:"+name);
	}
	@GetView(Method = "方法a", Value = "值b")
	public void test() {
		System.out.println("In test method.");
	}
	
}

