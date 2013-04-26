<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Hello using forward to JSP</title>
</head>
<body>
<h1>Hello
    <c:if test="${not empty nameFromForward}">
        <c:out value=" ${nameFromForward}"/>
    </c:if>!!!
</h1>

<p>Forward from servlet to JSP</p>
</body>
</html>