package com.study.tool;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTimeTest {
	public static void main(String[] args) {
		//jdk1.8
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);//减一天
		System.out.println("今天此刻:"+today+"昨天此刻:"+yesterday);
		
		
		Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));    // 0 - 11
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        System.out.println("本月最小天数:"+cal.getActualMinimum(cal.DAY_OF_MONTH));    //获取本月最小天数
        System.out.println("本月最大天数:"+cal.getActualMaximum(cal.DAY_OF_MONTH));    //获取本月最大天数
        System.out.println(cal.getTime());
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
	}
}
