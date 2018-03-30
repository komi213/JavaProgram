<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>12</h2>
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

</body>
</html>
