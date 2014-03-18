<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка доступа</title>
</head>
<body>
<h1 style="color:red;">Доступ закрыт</h1>

Пользователь <b><%=request.getUserPrincipal().getName()%></b> не имеет прав для доступа к запрашиваемому ресурсу

<hr/>
<a style="float: left" href="javascript:history.back()">Назад</a>

<a style="float: right" href="../logout">Выйти</a>
<div style="clear: both;"></div>

</body>
</html>