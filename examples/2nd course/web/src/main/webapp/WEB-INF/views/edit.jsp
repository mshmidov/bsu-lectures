<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //Set no caching
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<html>
    <head>
        <title>List</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/ie-fixes.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/demoPage.js"></script>
    </head>
    <body>
        <h2>Person object: edit mode</h2>

        <form id="myform" action="<%=request.getContextPath()%>/demo/person" method="post">
            <table>
                <tr>
                    <td>Id(Required)</td>
                    <td><input id="id" name="personId" value="${person.id}"/></td>
                </tr>
                <tr>
                    <td>First Name(Required)</td>
                    <td><input id="firstName" name="personFirstName" value="${person.firstName}"/></td>
                </tr>
                <tr>
                    <td>Last Name(Required)</td>
                    <td><input id="lastName" name="personLastName" value="${person.lastName}"/></td>
                </tr>
            </table>

            <button onclick="return validateAndSubmit();">Save</button>
        </form>
    &lt;form action="&lt;%=request.getContextPath()%&gt;/demo/person" method="post"&gt;&lt;/form&gt;
    </body>
</html>