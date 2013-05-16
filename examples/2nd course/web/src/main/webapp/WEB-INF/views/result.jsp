<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //Set no caching
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<html>
    <head>
        <title>Updated object</title>
    </head>
    <body>
        <h2>Person object</h2>

        <table>
            <tr>
                <td>id</td>
                <td><c:out value="${person.id}"/></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><c:out value="${person.firstName}"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><c:out value="${person.lastName}"/></td>
            </tr>
        </table>
        
        <a href="<%=request.getContextPath()%>/demo/person?id=${person.id}">Click to edit</a>
    
    </body>
</html>