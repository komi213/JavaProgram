package com.study.tool.Arithmetic;

import java.util.Comparator;

/**
 * 冒泡排序接口
 * @author komi
 *
 */
public interface Sorter {
	//方法的重载(参数类型或者参数数量必须改变),返回类型可变、可不变。
	/**
    * 排序
    * @param list 待排序的数组
    */
	public <T extends Comparable<T>> void sort(T[] list);
	
	/**
	 * 排序
	 * @param list 待排序的数组
	 * @param comp 比较两个对象的比较器
	 */
	public <T> void sort(T[] list,Comparator<T> comp);
}
