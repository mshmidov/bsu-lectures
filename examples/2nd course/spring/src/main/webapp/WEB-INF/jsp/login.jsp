<%--
  Created by IntelliJ IDEA.
  User: mshmidov
  Date: 4/12/13
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form action="/user/login/" method="POST">

        <label for="login">User name:</label>
        <input type="text" name="userName" id="login"/>
        <input type="submit" value="Login"/>

    </form>

</body>
</html>
