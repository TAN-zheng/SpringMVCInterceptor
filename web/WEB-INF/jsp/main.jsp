<%--
  Created by IntelliJ IDEA.
  User: TAN
  Date: 2021/3/10
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统主页</title>
</head>
<body>
    当前用户：${USER_SESSION.username}
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
