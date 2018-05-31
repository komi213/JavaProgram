<%@page import="com.study.model.UserT"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习JSTL(JSP标准标签库)</title>
</head>
<body>
	<!-- 1. 遍历List 字符串集合 -->
	<p>1. 遍历List 字符串集合</p>
	<%
		List<String> list = new ArrayList();
		list.add("11列表");
		list.add("22");
		list.add("33");
		pageContext.setAttribute("strlist",list);
	%>
	<c:forEach var="varstrlist" items="${strlist}">   
        <c:out value="${varstrlist}"></c:out>  
        <br/> 
    </c:forEach>
    
    <!-- 2. 遍历List 对象集合 -->
    <p>2. 遍历List 对象集合</p>
     <%  
    List<UserT> list2 = new ArrayList<UserT>();  
     
     UserT usert1 = new UserT();  
     usert1.setId(9);  
     usert1.setUserName("学生1");  
     usert1.setAge(11);  
     usert1.setPassword("密码:111");  
	  
     UserT usert2 = new UserT();  
	usert2.setId(10);  
	usert2.setUserName("学生2");  
	usert2.setAge(22); 
	usert2.setPassword("密码:222");  
	  
	list2.add(usert1);  
	list2.add(usert2);  
	pageContext.setAttribute("volist",list2); 
    %>  
    <c:forEach var="varvolist" items="${volist}">   
        <c:out value="${varvolist.id}"></c:out>  
        <c:out value="${varvolist.userName}"></c:out>  
        <c:out value="${varvolist.age}"></c:out>  
        <c:out value="${varvolist.password}"></c:out>  
        <br/>  
    </c:forEach>
    <!-- 3.遍历List数组集合 -->
    <p>3.遍历List数组集合</p>
    <%
    	List<String[]> arrlist = new ArrayList<String[]>();
    	String []arr1 = {"1","11","111啊"};
    	String []arr2 = {"2","22","222啊"};
    	arrlist.add(arr1);
    	arrlist.add(arr2);
    	pageContext.setAttribute("arrlist", arrlist);
    %>
    <c:forEach var="vararrlist" items="${arrlist}">
    	<c:out value="${vararrlist[0]}"></c:out>
    	<c:out value="${vararrlist[1]}"></c:out>
    	<c:out value="${vararrlist[2]}"></c:out>
    </c:forEach>
   <!-- 4. 遍历Set集合 -->
   <p>4. 遍历Set集合</p>
    <%
    	Set<String> set = new HashSet<String>();
   		set.add("1");
   		set.add("2");
   		set.add("3");
   		pageContext.setAttribute("set", set);
    %>
    <c:forEach var="varset" items="${set}">
    	<c:out value="${varset}"></c:out>
    </c:forEach>
    <!-- 5. 遍历 Map 集合 -->
    <p>5. 遍历 Map 集合</p>
    <%
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("1","11");
    	map.put("2","22");
    	map.put("3","33");
    	pageContext.setAttribute("map", map);
    %>
    <c:forEach var="varmap" items="${map}">
    	键是:<c:out value="${varmap.key}"></c:out>
    	值是:<c:out value="${varmap.value}"></c:out>
    </c:forEach>
    <!-- 6. 遍历Map 集合（值是List集合） -->
    <p>6. 遍历Map 集合（值是List集合）</p>
    <%
    	Map<String,List<String>> map2 = new HashMap<String,List<String>>();
    	ArrayList<String> arr3 = new ArrayList<String>();
    	arr3.add("111");
    	arr3.add("11111");
    	
    	ArrayList<String> arr4 = new ArrayList<String>();
    	arr4.add("222");
    	arr4.add("22222");
    	
    	map2.put("1", arr3);
    	map2.put("2", arr4);
    	pageContext.setAttribute("map2", map2);
    %>
    <c:forEach var="varmap2" items="${map2}">
    	键是：<c:out value="${varmap2.key}"></c:out>
    	值是：
    	<c:forEach var="varvalue" items="${varmap2.value }">
    		<c:out value="${varvalue}"></c:out>
    	</c:forEach>
    </c:forEach>
    
    
</body>
</html>