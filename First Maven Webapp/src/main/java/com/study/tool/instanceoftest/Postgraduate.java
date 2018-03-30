package com.study.tool.instanceoftest;

/**
 * 研究生
 * @author komi
 *
 */
public class Postgraduate extends Student{
	public Postgraduate() {
		// TODO Auto-generated constructor stub
		System.out.println("Postgraduate类:构造函数");
	}
	private String degree;//学历 
	public static int X=111;  
    public final static int Y=222;
    static{  
        System.out.println("Postgraduate中static语句块执行");  
    }  
    public static void display(){  
        System.out.println("Postgraduate中静态方法被执行");  
    }  
    public void display_1(){  
        System.out.println("Postgraduate中实例方法被执行");  
    }
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	@Override
	public String toString() {
		return "Postgraduate [degree=" + degree + ", toString()=" + super.toString() + "]";
	}  
	
}
