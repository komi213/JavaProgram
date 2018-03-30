package com.study.tool.Arithmetic;

import java.util.Comparator;

/**
 * 二分查找(折半查找)
 * @author komi
 *
 */
public interface BinarySearch {
	public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
	      return binarySearch(x, 0, x.length- 1, key);
	   }
	/**
	 * 使用循环实现的二分查找
	 * @param x：升序的数组
	 * @param key:要查找的值
	 * @param comp:实现排序接口
	 * @return
	 */
	public static <T> int binarySearch(T[] x,T key,Comparator<T> comp){
		int low = 0;
		int high = x.length-1;
		while(low <= high){
			int mid = (low+high)>>>1;//逻辑右移：>>>，不管正数、负数，左端都用0补充。
			int cmp = comp.compare(x[mid], key);
			//如果中间mid<key
			if(cmp<0){
				low = mid+1;
			}else if(cmp>0){//如果中间mid>key
				high = mid-1;
			}else{//如果中间mid==key
				return mid;
			}
		}
		return -1;
	}
	//使用递归实现的二分查找
	public static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
      if(low <= high) {
        int mid = (low + high) >>> 1;//不应该使用(high+ low) / 2的方式,因为加法运算可能导致整数越界
        if(key.compareTo(x[mid])== 0) {
           return mid;
        }
        else if(key.compareTo(x[mid])< 0) {
           return binarySearch(x,low, mid - 1, key);
        }
        else {
           return binarySearch(x,mid + 1, high, key);
        }
      }
      return -1;
   }
}
