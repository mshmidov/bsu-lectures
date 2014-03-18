<%@ page import="java.security.Principal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Secured page</title>
</head>
<body>
    <h1>Это защищенная страница</h1>

    <a href="admin.jsp">Страница только для администратора</a><br/>
    <br/>
    <a href="user.jsp">Страница только для пользователя</a><br/>
    <br/>
    <a href="admin-user.jsp">Страница для администратора и пользователя</a><br/>

    <jsp:include page="footer.jsp"/>
</body>
</html>