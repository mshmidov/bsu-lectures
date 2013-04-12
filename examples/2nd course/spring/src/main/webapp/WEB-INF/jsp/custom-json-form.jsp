<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom Json</title>
</head>
<body>
    <c:if test="${not empty authentication}">
        <p><c:out value="Current user: ${authentication.loggedUserName}"/></p>
    </c:if>

    <form:form action="/forms/custom-json" method="POST" modelAttribute="customJsonRequest">
        <table>
            <tr>
                <td><form:label path="name">name</form:label></td>
                <td><form:input path="name" id="name"/></td>
            </tr>
            <tr>
                <td><form:label path="value">name</form:label></td>
                <td><form:input path="value"/></td>
            </tr>

            <tr>
                <td colspan="2">
                   <input type="submit" value="Request custom json"/>
                </td>
            </tr>
        </table>


    </form:form>
</body>
</html>
