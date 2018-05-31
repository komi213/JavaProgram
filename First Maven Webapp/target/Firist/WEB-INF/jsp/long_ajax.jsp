<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<title>ajax实现长连接</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.8.0.js"></script>
<script>
	$(function(){
		(function longPolling(){
			$.ajax({
				url:"<%=request.getContextPath()%>/poll/ajax",
				data:{"requestTime":new Date().getTime()},
				dataType:"text",
				timeout:5000,
				error:function(XMLHttpRequest,textStatus,errorThrown){
					$("#logs").append("[state: " + textStatus + ", error: " + errorThrown + " ]<br/>");
					if(textStatus == "timeout"){//请求超时
						longPolling();//递归调用
					}else{// 其他错误，如网络错误等
						longPolling();
					}
				},success:function(data, textStatus){
					$("#logs").append("[state: " + textStatus + ", data: { " + data + "} ]<br/>");
					if(textStatus == "success"){//请求成功
						longPolling();
					}
				}
			});
		})();
	});
</script>
</head>
<body>
	<p>
		上面这段代码就是才有Ajax的方式完成长连接，主要优点就是和服务器始终保持一个连接。
		如果当前连接请求成功后，将更新数据并且继续创建一个新的连接和服务器保持联系。
		如果连接超时或发生异常，这个时候程序也会创建一个新连接继续请求。
		这样就大大节省了服务器和网络资源，提高了程序的性能，从而也保证了程序的顺序。
	</p>
	<div id="logs"></div>
</body>
</html>