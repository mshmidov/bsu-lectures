<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Framework example</title>
</head>
<body>
    <h1>Spring Framework example</h1>
    <c:if test="${not empty authentication}">
        <p><c:out value="Current user: ${authentication.loggedUserName}"/></p>
    </c:if>
    <ul>
        <li><a href="resource/text">Get some text</a></li>
        <li><a href="resource/json">Get some JSON</a></li>
        <li><a href="forms/custom-json">Get some custom JSON</a></li>
        <li><a href="user">Play with sample authentication</a></li>
    </ul>


</body>
</html>
