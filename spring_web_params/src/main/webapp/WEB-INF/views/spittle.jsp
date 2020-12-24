<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="spittleViwe">
    <div class="spittleMessage">
        <c:out value="${spittle.message}" />
    </div>
    <div>
    <span class="spittleTime">
      <c:out value="${spittle.time}" />
    </span>
    </div>
</div>
</body>
</html>
