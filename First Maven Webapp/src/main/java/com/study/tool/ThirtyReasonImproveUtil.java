package com.study.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 30项风险原因和改善方向
 * @author komi
 *
 */
public class ThirtyReasonImproveUtil {
	
	public static final Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
	static{
		List<String> list = new ArrayList<String>();
		list.add("123434");
		list.add("123434");
		list.add("123434");
		list.add("123434");
		list.add("123434");
		list.add("123434");
		map.put(1001, list);
		
		list = new ArrayList<String>();
		list.add("123434");
		list.add("123434");
		list.add("123434");
		list.add("123434");
		list.add("123434");
		list.add("123434");
		map.put(1002, list);
	}
	
	public static List<String> getThirtyReason(int dangerType){
		List<String> list = new ArrayList<String>();
		list = map.get(dangerType);
		if(list!=null){
			return list;
		}
		return new ArrayList<String>();
	}
	
	public static List<String> getThirtyImprove(int dangerType){
		
		return null;
	}
}
