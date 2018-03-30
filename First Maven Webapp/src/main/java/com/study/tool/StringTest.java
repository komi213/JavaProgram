package com.study.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class StringTest {
	public static void main(String[] args) {
		String reverseStr = StringTest.reverse("AB");
		System.out.println(reverseStr);
		//字符串替换
		String a1 = "a3b29";
		System.out.println(a1.replace("a", "0").replace("9", "6"));
		
		List<String> typeList = new ArrayList<String>();
		typeList.add("image");
		typeList.add("voice");
		typeList.add("video");
		typeList.add("thumb");
		if(typeList.contains("voice")){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
		
		String a2 = "{'a':'10ypugT2JFMqm-A_y8tcXDU0o9ijVuwrhu21OnPzvhaTHkB6d5tLK5mQIGbrzEbG'}";
		/*JSONObject jsonData = JSONObject.parseObject(a2.toString());
		System.out.println(jsonData);*/
		
		Integer ab = 0;
		ab = (int) (((float)35/64)*100);
		System.out.println((int)56.9);
		
		
		Map<String,StringBuffer> errorMap = new HashMap<String,StringBuffer>(){{
			put("1",new StringBuffer("1a"));
			put("2",new StringBuffer("2b"));
			put("2",new StringBuffer("3c"));
		}};
		//1，entrySet实现了Set接口，里面存放的是键值对。一个K对应一个V。
		//2，用来遍历map的一种方法。
		if(errorMap != null){  
			Set<Entry<String, StringBuffer>> ets = errorMap.entrySet();
			for(Map.Entry<String, StringBuffer> m : ets){  
                System.out.println(m.getKey() + ":" + m.getValue().toString());  
            }  
        }  
		//还有一种是keySet。里面存的是Map的K。
		Set<String> set = errorMap.keySet();   
		  for (String s:set) {  
		   System.out.println(s+","+errorMap.get(s));  
		  } 
		  //Simple JSON测试
		  String abc = "{\"a\":\"1\",\"b\":\"3\"}";
		  JSONObject jo = (JSONObject) JSONValue.parse(abc);
		  System.out.println(jo.toJSONString());
		  
		  
		  StringBuffer s;

		  s = new StringBuffer("Java");

		  StringBuffer s1 = s;

		  s1.append(" World");

		  System.out.println("s1=" + s1.toString());//打印结果为：s1=Java World

		  System.out.println("s=" + s.toString());//打印结果为：s=Java World
		  
		  String b1 = "1234";
		  String b2 = b1.concat("999");
		  System.out.println(b1);
		  System.out.println(b2);
		
	}
	//字符串反转（递归方法来实现）
	public static String reverse(String originStr){
		if(originStr == null || originStr.length()<=1)
			return originStr;
		return reverse(originStr.substring(1))+originStr.charAt(0);
	}
	
	
}
