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
			$("#logs").append("[data: " + $($("#frame").get(0).contentDocument).find("body").text() + " ]<br/>");
			$("#frame").attr("src","<%=request.getContextPath()%>/poll/ajax?requestTime="+new Date().getTime());	
            /* // 延迟1秒再重新请求
            window.setTimeout(function () {
                window.frames["polling"].location.reload();
            }, 1000); */
		}, 5000)
	});
</script>
</head>
<body>
	<p>
		这里的客户端程序是利用隐藏的iframe向服务器端不停的拉取数据，将iframe获取后的数据填充到页面中即可。
		同ajax实现的基本原理一样，唯一不同的是当一个请求没有响应返回数据的情况下，下一个请求也将开始，这时候前面的请求将被停止。
		如果要使程序和上面的ajax请求一样也可以办到，那就是给每个请求分配一个独立的iframe即可。
	</p>
	<p style="color:read;">其中红色是没有成功返回请求就被停止（后面请求开始）掉的请求，黑色是成功返回数据的请求。</p>
	<iframe id="frame" name="polling" style="display: none;"></iframe>
	<div id="logs"></div>
</body>
</html>