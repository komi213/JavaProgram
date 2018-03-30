package com.study.tool;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

public class test {
	public static void main(String[] args) {
		//13个系统的，每个系统总体扣分数
		final HashMap<String, String> sysKillScoreMap = new HashMap<String,String>(){{ 
	        put("BMI" , "-5");
	        put("免疫力系统" , "-6");
	        put("电解质指数" , "-6");
	        put("呼吸系统" , "-6");
	        put("循环系统" , "-6");
	        put("消化系统" , "-6");
	        put("泌尿系统" , "-6");
	        put("生殖系统" , "-6");
	        put("内分泌系统" , "-6");
	        put("心情指数" , "-6");
	        put("神经系统" , "-6");
	        put("运动系统" , "-6");
	        put("健康透支指标" , "-6");
		}}; 
		//map转json对象
		System.out.println(JSONObject.toJSONString(sysKillScoreMap));
		List<String> scoreMapList = new ArrayList<String>();
		scoreMapList.add("201605");
		scoreMapList.add("201607");
		scoreMapList.add("201608");
		scoreMapList.add("201609");
		scoreMapList.add("201610");
		//全部数据取出来，截取前10条
		if(scoreMapList!=null&&scoreMapList.size()>4){
			scoreMapList = scoreMapList.subList(0, 4);
		}
		System.out.println(scoreMapList);
		
		Map<String,Object> a = new HashMap<String,Object>();
		a.put("k1", 0);
		a.put("k2",3);
		System.out.println(a.getOrDefault("k2", 4));
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("userEvalId", "");
		Integer sex = jsonData.getInteger("userEvalId");
		if(sex!=null){
			System.out.println("1");
		}else{
			System.out.println("0");
		}
		
		String[] valArray = new String[2];
		if(valArray[0]==null){
			System.out.println(valArray.length);
		}
		
		Integer a1 = 3;
		Integer b1 = 3;
		float a2 = (float) 8.4;
		double b2 = 2;
		if(a1 == b1){
			System.out.println((float)(a2/b2));
		}else if(a1.equals(b1)){
			System.out.println("equals 3");
		}
		
		float a3 = 3.46891f;
		DecimalFormat fnum1 = new DecimalFormat("##0.0");
		DecimalFormat fnum2 = new DecimalFormat("#0.##");
		System.out.println(fnum1.format(a3));
		System.out.println(fnum2.format(a3));
		
		System.out.println((float)(Math.round(a3*100))/100);
		
		DecimalFormat formater = new DecimalFormat("#0.###");
		formater.setRoundingMode(RoundingMode.FLOOR);
		System.out.println(formater.format(0.7896));
		
		
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);  
        
        try {
        	queue.put("Hello");
        	queue.put("World!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        System.out.println(queue.size());
        String str;
        while((str=(String) queue.poll())!=null){
            System.out.print(str);
            System.out.println(queue.size());
        }
        System.out.println(queue.size());
        double d1 = Math.random();//此方法返回一个伪随机double大于或等于0.0且小于1.0。
        int d2 = (int)(d1*10);//不会四舍五入
        char d3 = '中';
        System.out.println(d2+"----"+d3);
        System.out.println(d1+"==="+(int)(d1*10000));//产生0-9999随机数
        
        Integer d8 = 2;
        //字符串比较
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s1 == s3);//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1 == s1.intern());//true
        System.out.println(s1.equals(s1.intern()));//true
        System.out.println(d8);
        
        String abc = null;
        System.out.println(StringUtils.isNotBlank(abc));
        //数组复制并增加长度
        String[] s5 = new String[3];
        s5[0] = "1a";
        s5[1] = "1b";
        for(String s:s5){
        	System.out.println(s);
        }
        System.out.println("s5数组之前长度"+s5.length);
        s5 = Arrays.copyOf(s5, 2*3+1);
        for(String s:s5){
        	System.out.println(s);
        }
        System.out.println("s5数组复制并增加长度"+s5.length);
        
        String[] arr = {"1","a","de","f"};
        System.out.println("是否存在"+ArrayUtils.contains(arr,"a"));
        
        HashMap<String,Object> abc1 = new HashMap<String,Object>();
        abc1.put("c1", 2);
        System.out.println(abc1.get("c2"));
        String e1 = "3999";
        System.out.println("字符串是否是整数:"+StringUtils.isNumeric(e1));
        
	}
	
}
