<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.8.0.js"></script>
<script>
	$.ajax({
		url:"/First/get/json",
		type:"POST",
		data:{"a":"1","b":"13就就了"},
		dataType:"json",
		success:function(data){
			alert(JSON.stringify(data));
		},
		error:function(){
			alert("请求出错");
		}
	});
</script>
</head>
<body>
利用ajax获取json数据,并输出
</body>
</html>