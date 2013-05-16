<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //Set no caching
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<html>
  <head>
    <title>Java application examples</title>
  </head>
  <body>
        <h2>Simple web application</h2>
        <h2>Добро пожаловать в веб приложение</h2>
        <hr>

        <h2>Hello World</h2>
        Click <a href="<%=request.getContextPath()%>/demo/person">this link</a> to see "Person Demo"<br>
        Click <a href="<%=request.getContextPath()%>/pages/localizationExample.jsp">this link</a> to see "Localization example"<br>
        Click <a href="<%=request.getContextPath()%>/pages/imageExample.jsp">this link</a> to see "Image Servlet"<br>
        Click <a href="<%=request.getContextPath()%>/pages/fileExample.jsp">this link</a> to see "File Servlet"<br>
        Click <a href="<%=request.getContextPath()%>/pages/fileUploadExample.jsp">this link</a> to see "Upload Servlet"<br>
        Click <a href="<%=request.getContextPath()%>/pages/secure/protectedPage.jsp">this link</a> to see "Secure page"
  </body>
</html>