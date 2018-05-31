<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>用户列表userList</h2>
<table>
	<c:forEach items="${users}" var="user" varStatus="vs">  
        <tr>  
             <td>  
                <s:property value="#vs.index+1"/>  
             </td>  
             <td align = "center">${user.id}</td>  
             <td align = "center">${user.userName}</td>  
             <td align = "center">${user.password}</td>  
             <td align = "center">${user.age}</td>  
         </tr>  
	</c:forEach>
</table>

</body>
</html>