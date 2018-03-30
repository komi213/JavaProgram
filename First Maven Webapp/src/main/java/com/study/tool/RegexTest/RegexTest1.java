package com.study.tool.RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest1 {
    /*(一)支持的基本通配符：
    .   -可以匹配任意字符
    \s  -代表一个任意空白(空格、Tab)。
    \S  -代表一个任意的非空白。
    \d  -代表一个任意的数字(digital)。
    \D  -代表一个任意的非数字。
    \w  -代表一个单词字符。
    -W  -代表一个任意的非单词字符
    \b	匹配单词的开始或结束
    \B	匹配不是单词开头或结束的位置
	^	匹配字符串的开始
	$	匹配字符串的结束
    注意：对于特殊字符，实际使用时记住要转义\ ，如：( ) [ ] { } \ ? * + ^（一行的开头） $（一行的结尾）|

    (二)取值范围（用作出现次数的“副词”）
    ? --代表它前面的东西可以出现0~1次
    * --代表它前面的东西可以出现0~N次 
    + --代表它前面的东西可以出现1~N次
    {n,m} --代表它前面的东西可以出现n~m次
    {n,} --代表它前面的东西至少出现n次
    {,m} --代表它前面的东西最多出现m次
    {n} --代表它前面的东西必须出现n次
    (三)方括号表达式
     [^x]	匹配除了x以外的任意字符
	 [^aeiou]	匹配除了aeiou这几个字母以外的任意字符
	    枚举：[ab1]  --代表a或b或者1。
	    范围：[a-c]  --代表a,b,c中的任意一个字符。
	    枚举与范围：[a-c1-3]--代表a,b,c,1,2,3中的任意一个字符。
	    表示求否：[^a-c] --代表不含a,b,c其中任意一个字符。
	    表示求交：[a-g&&[^b-d]]：--代表a,e,f,g中的任意一个字符。
	    表示必须含有其中之一：(com|org|cn)
	    总结：一个字符用\，多个字符用[]，字符次数用{} 
	 [\u4e00-\u9fa5]:\u4e00-\u9fa5是所有汉字的unicode编码范围 */
    public static void main(String[] args) {
    	String REGEX = "a*b";  
        String INPUT = "aabfooaabfooabfoob";  
        String REPLACE = "-";
        Pattern p = Pattern.compile(REGEX);  
        Matcher m = p.matcher(INPUT);       // 获得匹配器对象 
        while(m.find()){
        	System.out.println(m.group());//正则表达式匹配的字串
        }
        INPUT = m.replaceAll(REPLACE);  
        System.out.println(INPUT);  
        
        // 单个字符  
        System.out.println("a".matches("."));
        // 0~1个a  
        System.out.println("a".matches("a?"));
        // 1~N个a  
        System.out.println("aaaa".matches("a+"));  
        // 0~N个a  
        System.out.println("".matches("a*"));  
        // 1~N个q和1个0~9之间的数字  
        System.out.println("qqqqqq3".matches("q+[0-9]")); 
        // 1~3个数字分别以.分割  
        System.out.println("192.168.0.1"  
                .matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));  
        // 第一个数字0~2，第二个数字0~9，第三个数字0~9  
        System.out.println("192".matches("[0-2][0-9][0-9]"));  
        // 4个任意空白  
        System.out.println(" \n\r\t".matches("\\s{4}"));  
        // 特殊字符\需转义  
        System.out.println("\\".matches("\\\\"));  
        // 以h开头，中间有0~N个字符，最后以o结尾  
        System.out.println("hello".matches("^.*o$"));  
        // 以h开头，中间1~3个字母尾随一个o，接着空白连着0~N个字符并以d结尾  
        System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*d$"));  
        // 以任意空白且不以换行开头为开头，并以换行结尾  
        System.out.println("   \n".matches("^[\\s&&[^\\n]]*\\n$"));  
        // 0~N个字符，连接4个数字和一个字符  
        System.out.println("aaa 2222q".matches(".*\\d{4}."));  
        
        String s1 = "123456012398-45678-987-11";  
        Pattern pattern = Pattern.compile("\\d{3,5}"); // 匹配3~5个数字  
        Matcher matcher = pattern.matcher(s1);  
        //matches()方法用来判断整个输入字符串是否匹配（正则表达式）
        System.out.println("matches方法匹配整个字符串是否满足正则表达式："+matcher.matches());// false
        matcher.reset();// 重置匹配器，将其添加位置设置为零  
        while(matcher.find()){// true，由于重置了匹配器此时将从起始位置查找  
	        System.out.println(matcher.group()+":"+matcher.start() + "-" + matcher.end());// 位置：0-3  
        }
       
        // 与matches方法唯一不同的是lookingAt不需要匹配整个区域 ,它永远是从第一个子串开始  
        System.out.println(matcher.lookingAt());// true  
        System.out.println(matcher.lookingAt());// true
        
    }  
}
