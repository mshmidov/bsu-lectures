<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>

    <h1>Current user:</h1>

    <c:if test="${not empty authentication}">
        <p><c:out value="Current user: ${authentication.loggedUserName}"/></p>
    </c:if>
    <form action="user/logoff" method="POST">
        <input type="submit" value="Log off">
    </form>

</body>
</html>
