<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<% response.setStatus(HttpServletResponse.SC_OK); %>  
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
    <head>
        <title>错误页面</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.js"></script>
        
    </head>
    <body>
      	 error.jsp 错误页面！！！
      	 <div>当前时间:<%= new Date().toLocaleString() %></div>
    </body>
</html>