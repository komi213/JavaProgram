package com.study.tool.TreeSetTest;

public class Student implements Comparable<Student>{
	private String name;
	private int age;
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString(){
		return "Student [name="+name+",age="+age+"]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.age - o.age; // 比较年龄(年龄的升序)
	}
	
}
