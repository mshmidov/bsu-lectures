<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2">
    <thead>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <tags:role-access rolesAllowed="admin">
            <th>Password (visible only for admin)</th>
        </tags:role-access>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    </thead>
    <tbody>
    <tags:iterate var="user" items="${requestScope['users']}">
        <tr>
            <td>${user.id}</td>
            <td>
                <tags:role-access rolesAllowed="user">
                <a href="mailto:${user.email}">${user.email}</a>
                </tags:role-access>
                <tags:role-access rolesAllowed="admin">
                ${user.email}
                </tags:role-access>
            </td>
            <tags:role-access rolesAllowed="admin">
                <td>${user.password}</td>
            </tags:role-access>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </tags:iterate>
    </tbody>
</table>

<hr/>
<a style="float: right" href="../logout">Выйти</a>
</body>
</html>