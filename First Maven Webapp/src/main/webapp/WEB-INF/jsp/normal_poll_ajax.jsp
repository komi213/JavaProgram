<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<title>普通轮询 Ajax方式</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.8.0.js"></script>
<script>
	$(function(){
		window.setInterval(function(){
			$.get("<%=request.getContextPath()%>/poll/ajax",
				{"requestTime":new Date().getTime()},
				function(data){
					$("#logs").append("[data:"+data+"]<br/>");
				});
		}, 3000)
	});
</script>
</head>
<body>
	<p>
		客户端实现的就是用一种普通轮询的结果，比较简单。利用setInterval不间断的刷新来获取服务器的资源，这种方式的优点就是简单、及时。
		缺点是链接多数是无效重复的；响应的结果没有顺序（因为是异步请求，当发送的请求没有返回结果的时候，后面的请求又被发送。
		而此时如果后面的请求比前面的请求要先返回结果，那么当前面的请求返回结果数据时已经是过时无效的数据了）；
		请求多，难于维护、浪费服务器和网络资源。
	</p>
	<div id="logs"></div>
</body>
</html>