package com.study.tool.genericity;

import java.util.List;

public class Order<T> {  
	
    private String name;  
    private T age;  
    public Order(T t){
    	this.age = t;
    }
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    
    //泛型方法的定义  
    public <E> E getE(E e) {  
        return e;  
    }  
      
    public <E> void fromArrayToList(E[] e , List<E> list) {  
        for (E e1 : e) {  
            list.add(e1);  
        }  
    }
	public T getAge() {
		return age;
	}
	public void setAge(T age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", age=" + age + "]";
	}  
}  
