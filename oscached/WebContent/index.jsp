<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.opensymphony.com/oscache" prefix="oscache" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
现在时间：<%=new Date() %>
缓存：默认域:application 整个项目，可以指定域如： scope="session"当前连接<br>
指定缓存时间：time=3 单位秒  ,默认存到内存.可以指定存到硬盘(修改oscache.properties文件)<br>
<oscache:cache scope="session">
缓存时间：<%=new Date() %>
</oscache:cache>
</body>
</html>