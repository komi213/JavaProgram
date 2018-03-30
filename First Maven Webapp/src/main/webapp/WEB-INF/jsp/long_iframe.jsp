<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<title>长连接iframe方式无序</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.8.0.js"></script>
<script>
	$(function(){
		window.setInterval(function(){
			var url = "<%=request.getContextPath()%>/poll/ajax?requestTime="+new Date().getTime();
			var $iframe = $('<iframe id="frame" name="polling" style="display: none;" src="' + url + '"></iframe>');
			$("body").append($iframe);
            $iframe.load(function () {
                $("#logs").append("[data: " + $($iframe.get(0).contentDocument).find("body").text() + " ]<br/>");
                $iframe.remove();
            });
			
		}, 5000)
	});
</script>
</head>
<body>
	<p>
		这个轮询方式就是把刚才上面的稍微改下，每个请求都有自己独立的一个iframe，
		当这个iframe得到响应的数据后就把数据push到当前页面上。
		使用此方法已经类似于ajax的异步交互了，这种方法也是不能保证顺序的、比较耗费资源、
		而且总是有一个加载的条在地址栏或状态栏附件（当然要解决可以利用htmlfile，
		Google的攻城师们已经做到了，网上也有封装好的lib库），
		但客户端实现起来比较简单。
		
	</p>
	
	<div id="logs"></div>
</body>
</html>