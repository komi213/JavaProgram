package cn;

import com.study.tool.instanceoftest.Student;

public class Test2 {
	public static void main(String[] args) {
		//同一个时间，不同时区(CDT与CST两个时区)，不同时间戳
		 /*System.out.println(new Date(527004000000l)+"==="+sdf2.format(new Date(527004000000l)));//Sat Sep 13 23:00:00 CDT 1986一定要看到CDT
        	System.out.println(new Date(527007600000l)+"==="+sdf2.format(new Date(527007600000l)));//Sat Sep 13 23:00:00 CST 1986 一定要注意CST
		  */
		//Class类测试
		System.out.println(Student.class);
		System.out.println(Student.class.getName());
	    System.out.println(Student.class.getSimpleName());
	    try {
			Class<?> studentClass = Class.forName(Student.class.getName());
			System.out.println(studentClass.getName());
			System.out.println(studentClass.getSimpleName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    //读取和修改类的静态变量
	    System.out.println(Student.X);
	    Student.X = 77;
	    System.out.println(Student.X);
	    Student student = new Student();
	    Student.test1(student);
	    //下面是一些得到classpath和当前类的绝对路径的一些方法
	    System.out.println(Student.class.getResource(""));//file:/D:/First%20Maven%20Webapp/target/classes/com/study/tool/instanceoftest/
	    System.out.println(Student.class.getResource("/"));
	    
	}
}
