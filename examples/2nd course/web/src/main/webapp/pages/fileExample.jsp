<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //Set no caching
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<html>
    <head>
        <title>File example</title>
    </head>
    <body>
        Click <a href="<%=request.getContextPath()%>/dynamic/files?id=123">this link</a> to download a file
    </body>
</html>