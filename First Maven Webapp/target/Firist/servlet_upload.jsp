<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet图片上传</title>
</head>
<body>
	<h1>选择你要上传的图片</h1>
	<hr/>
	<div style="color:red;font-size:14px;">${hint}</div>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		图片文件:<input type="file" name="photo">
		<input type="submit" value="上传">
	</form>
</body>
</html>