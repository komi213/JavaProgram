<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<title>默认项目首页</title>
<link rel="stylesheet" href="/First/static/css/1.css">
<!-- 需要在spring-mvc.xml加入以下配置 -->
<!-- <mvc:resources mapping="/static/**" location="/WEB-INF/static/"/> -->
<!-- request.getContextPath()获取项目 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/jquery-1.8.0.js">
<body>
<h2>Hello World!(index web-inf下)</h2>
<form method="get" action="/First/test4">
	<c:out value="<h1>欢迎访问  escapeXml='false'不转义</h1>" escapeXml="false" />
	<c:out value="<h1>欢迎访问  escapeXml不设置，转义</h1>"/><br>
	<input type="text" name="name" value="komi">
	<input type="text" name="tel" value="15012345678">
	<input type="submit" value="提交"><br>
	
	<%
		int[] array = {1,2,3,4};
		ArrayList list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
	%>
	<c:set value="<%=array%>" var="vararray"></c:set>
	<c:set value="<%=list%>" var="varlist"></c:set>
	数组长度： ${fn:length(vararray)}<br/>
	集合长度： ${fn:length(varlist)}<br/>
	字符串长度： ${fn:length("Tomcat")}<br/>
	
	<p>
		四舍六入五成双<br>
		对于位数很多的近似数，当有效位数确定后，其后面多余的数字应该舍去，只保留有效数字最末一位，
		这种修约（舍入）规则是“四舍六入五成双”，也即“4舍6入5凑偶”这里“四”是指≤4 时舍去，
		"六"是指≥6时进上，"五"指的是根据5后面的数字(0不算)来定，当5后有数时，舍5入1；当5后无有效数字时，
		需要分两种情况来讲：①5前为奇数，舍5入1；②5前为偶数，舍5不进。（0是偶数）
	</p>
	<fmt:formatNumber value="0.36789" type="number"/><br />   
    <fmt:formatNumber value="1.205" type="currency" pattern="￥0.00"/><br />   
    <fmt:formatNumber value="1.215" type="currency" pattern="￥0.00"/><br /> 
     四舍六入五成双 改成"4舍5入":<fmt:formatNumber  value="${1.205 + 0.00001}"  pattern="￥0.00"/><br/>  
    <fmt:formatNumber value="0.36789" type="percent" pattern="0.00%"/><br />  
    <fmt:formatNumber value="0.36789" type="percent"/><br />
   
    
    (1):<fmt:formatDate value="<%=new Date() %>" type="date"/><br><br>
    (2):<fmt:formatDate value="<%=new Date() %>" type="time"/><br><br>
    (3):<fmt:formatDate value="<%=new Date() %>" type="both"/>
      
</form>
</body>
</html>
