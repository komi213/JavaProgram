package com.study.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//java比较器comparator使用
public class MapComparator implements Comparator<Map<String, Object>> {
	public static void main(String[] args) {
		List<HashMap<String,Object>> listHashMap = new ArrayList<HashMap<String,Object>>(){{
			add(new HashMap<String,Object>(){{
				put("name", "komi");
				put("date", "2016-8-16");
			}});
			add(new HashMap<String,Object>(){{
				put("name", "李四");
				put("date", "2016-5-19");
			}});
			add(new HashMap<String,Object>(){{
				put("name", "张三");
				put("date", "2016-9-25");
			}});
		}}; //Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
		
		Collections.sort(listHashMap, new MapComparator());
		for(HashMap<String,Object> map:listHashMap){
            System.out.println(map);
        }
		//输出
		/*{date=2016-5-19, name=李四}
		{date=2016-8-16, name=komi}
		{date=2016-9-25, name=张三}*/
		
	}
	@Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        // TODO Auto-generated method stub
        String b1 = o1.get("date").toString();
        String b2 = o2.get("date").toString();
        if (b2 != null) {
            return b1.compareTo(b2);
        }
        return 0;
    }
}
