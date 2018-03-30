package cn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.study.tool.genericity.Order;
import com.study.tool.instanceoftest.Person;
import com.study.tool.instanceoftest.Student;

public class Test1 {
	@Test
    public void selectAllInfo(){  
        DecimalFormat decimalFormat=new DecimalFormat(".00");
	    System.out.println(decimalFormat.format(1.245));
	    
	    List<String> list = new ArrayList<String>(4);
	    list.add("g");
	    list.add("f");
	    list.add("g");
	    list.add("b");
	    Set<String> set = new HashSet<String>(list);//
	    list.clear();//清空list
	    list.addAll(set);//把set重新赋给list
	    String[] array = new String[list.size()];
	    list.toArray(array);//list集合转数组
	    System.out.println(list.toString());
	    for(String s:array){
	    	System.out.println(s);
	    }
	    //调用自定义泛型(数组转集合)
	    Order<Integer> order = new Order<Integer>(2);
	    Order<Float> order2= new Order<Float>(5f);
	    Float age = order2.getAge();
	    order2.setAge(8.9f);
	    
	    Integer[] array2 = {8,7,9,21,5};
	    
	    List<Student> list3 = new ArrayList<>();
	    Student s1 = new Student();
	    s1.setName("komi");
	    Student s2 = new Student();
	    s1.setName("komi2");
	    Student s3 = new Student();
	    s1.setName("komi3");
	    list3.add(s1);
	    list3.add(s2);
	    list3.add(s3);
	    List<Person> list2 = new ArrayList<>(list3);
	    
	    System.out.println("---"+list2.toString());
	    //数组转list
	    List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(array2));
	    
	    List<Integer> list5 = new ArrayList<Integer>();
	    list5.add(58);
	    list5.add(8);
	    list5.add(8);
	    list5.add(26);
	    list5.add(8);
	    //利用迭代器删除指定项
	    Iterator<Integer> it = list5.iterator(); 
	    while(it.hasNext()){
	    	Integer next = it.next();
	    	if(next.equals(8)){
	    		it.remove();
	    	}
	    }
	    
	    //for循环删除指定项 要--i
	    /*for(int i=0; i<list5.size();i++){
	    	if(list5.get(i).equals(8)){
	    		list5.remove(i);
	    		--i;
	    	}
	    }*/
	    System.out.println(list5.toString());
	 
    }  
}
