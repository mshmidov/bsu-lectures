<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Hello using JSP</title>
</head>
<body>
    <h1>Hello<c:if test="${not empty param.name}"> <c:out value=" ${param.name}"/></c:if>!!!</h1>
    <p>Response to <c:out value="${pageContext.request.method}"/> request</p>
</body>
</html>
