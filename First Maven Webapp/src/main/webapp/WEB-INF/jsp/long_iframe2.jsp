<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<title>长连接iframe方式保证有序</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.8.0.js"></script>
<script>
	$(function(){
		(function iframePolling(){
			var url = "<%=request.getContextPath()%>/poll/ajax?requestTime="+new Date().getTime();
			var $iframe = $('<iframe id="frame" name="polling" style="display: none;" src="' + url + '"></iframe>');
			$("body").append($iframe);
            $iframe.load(function () {
               $("#logs").append("[data: " + $($iframe.get(0).contentDocument).find("body").text() + " ]<br/>");
               $iframe.remove();
               //递归
               iframePolling();
            });
			
		})();
	});
</script>
</head>
<body>
	<p>
		这种方式虽然保证了请求的顺序，但是它不会处理请求延时的错误或是说很长时间没有返回结果的请求，
		它会一直等到返回请求后才能创建下一个iframe请求，总会和服务器保持一个连接。
		和以上轮询比较，缺点就是消息不及时，但保证了请求的顺序。
		
	</p>
	
	<div id="logs"></div>
</body>
</html>