package com.study.tool.Arithmetic;

import java.util.Comparator;

/**
 * 冒泡排序实现类
 * @author komi
 *
 */
public class BubbleSorter implements Sorter {
	//最关键的是传入的T类型必须已经是实现了Comparable接口中compareTo()这个方法
	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		boolean swapped = true;
		for(int i=1,len = list.length;i<len&&swapped;++i){
			swapped = false;//避免已经排好序的数组，产生不必要的多次循环。
			//待排序的数组：{4,3,2,1},i=1时，4到最后面以后需要排列的就剩下了321 这3个数，
			//这就是为什么j<x.length-i了，随着i的增大，需要排列的数越来越少
			for(int j=0;j<len-i;++j){
				if(list[j].compareTo(list[j+1])>0){
					T temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					swapped = true;
				}
			}
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> comp) {
		// TODO Auto-generated method stub
		boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
	}

}
