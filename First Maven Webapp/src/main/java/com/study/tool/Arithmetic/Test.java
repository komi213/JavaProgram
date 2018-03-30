package com.study.tool.Arithmetic;

import java.util.Arrays;
import java.util.Comparator;

import com.study.tool.instanceoftest.Student;

public class Test {
	public static void main(String[] args) {
		//Integer类型实现了Comparable接口中compareTo()这个方法
		Integer[] listInt = {1,2,3,4}; //{4,3,2,1};
		BubbleSorter bs = new BubbleSorter();
		bs.sort(listInt);//方法一：调用类的排序方法(传入的T类型实现了Comparable接口中compareTo()这个方法)
		System.out.println(Arrays.toString(listInt));
		
		//定义Student数组
		Student s1 = new Student();
		s1.setName("komi");
		Student s2 = new Student();
		s2.setName("jumry");
		Student s3 = new Student();
		s3.setName("boy");
		Student[] listStudent = {s1,s2,s3};
		bs.sort(listStudent,new Comparator<Student>(){//方法二：实现一个比较接口的方法(匿名类)
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());    // 比较学生姓名
			}
			
		});
		for(Student s:listStudent){
			System.out.println(s.getName());
		}
		//折半查找(二分查找)是一种在有序数组中查找某一特定元素的搜索算法=======================
		Integer[] xList = {3,6,7,8,9,19};//有序的，升序排列
		Integer key = 6;
		//第一种：for循环方式实现折半查找
		int binarySearch = BinarySearch.binarySearch(xList,key,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		System.out.println("第一种方法：折半查找返回位置："+binarySearch);
		//第二种：递归方式实现折半查找
		int binarySearch2 = BinarySearch.binarySearch(xList,key);
		System.out.println("第二种方法：折半查找返回位置："+binarySearch2);
		
		//int类型的最大值范围: -2147483648(-2^31)到2147483647(2^31-1)
		int a1 = 2147483647;
		int a2 = 2147483647;
		//如果a1 + a2大于int最大值时，只有>>>1能保证结果正确。(都为正整数且整数不越界，两者结果一样)
		System.out.println((a1+a2)/2+"另一个:"+((a1+a2)>>>1));//-1另一个:2147483647(正整数越界，结果不一样,后者结果正确)
	}
}
