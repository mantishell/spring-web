<%--
  Created by IntelliJ IDEA.
  User: mantishell
  Date: 20-12-24
  Time: 下午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${spitter.username}" /><br/>
<c:out value="${spitter.firstName}" />
<c:out value="${spitter.lastName}" />
</body>
</html>
