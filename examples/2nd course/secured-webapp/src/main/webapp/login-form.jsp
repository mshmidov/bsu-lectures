
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизуйтесь</title>
</head>
<body>
<table width="100%" height="100%">
    <tr>
        <td align="center" valign="middle">
            <form action="../j_security_check" method="post">
                <label for="login">Логин:</label> <input id="login" type="text" name="j_username"><br/>
                <br/>
                <label for="passw">Пароль:</label> <input id="passw" type="password" name="j_password"><br/>
                <br/>
                <button type="submit">Войти</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>