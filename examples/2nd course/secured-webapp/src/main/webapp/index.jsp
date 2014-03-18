<%@ page import="java.security.Principal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Не защищенная траницы</title>
</head>
<body>
<h1>Не защищенная траницы</h1>

<a href="secured-folder">Перейти в защищенный каталог</a><br/>
<br/>
<a href="user/list" target="usersList">Перейти на список пользователей</a>


<%
    Principal p = request.getUserPrincipal();
    if (p != null) {
%>
<h3>
    Активный пользователь <%=p.getName()%>
</h3>
<hr/>
<a style="float: right" href="logout">Выйти</a>
<%}%>
</body>
</html>