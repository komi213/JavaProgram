<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="/WEB-INF/tld/my.tld" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>自定义标签测试</title>
	<style type="text/css">
	        * { font-family: "Arial"; font-size:20px; }
	</style>
	
</head>
<body>
	<a href="<%=basePath%>">返回首页</a>
	<p>
	日期格式：yyyy-MM-dd HH:mm:ss,SSS(年-月-日   时:分:秒,毫秒(3位数))<br>
	(HH-24小时制,hh-12小时制)
	</p>
	<my:time format="yyyy-MM-dd HH:mm:ss,SSS" backColor="blue" foreColor="yellow"/>
</body>
</html>