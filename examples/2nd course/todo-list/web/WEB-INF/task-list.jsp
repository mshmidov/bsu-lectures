<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks list</title>

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="style/main.css">
    <script src="http://code.jquery.com/jquery-2.1.0.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="task" method="post" class="navbar-form navbar-left">
        <input name="taskTitle" placeholder="Title" autocomplete="false" autofocus="true" class="form-control"/>
        <input type="submit" class="btn btn-info" value="Create">
    </form>
    <c:if test="${not empty tasks}">
    <div class="span8 tasks-table table-responsive">
    <table class="table table-hover">
        <tr>
            <th></th>
            <th>Title</th>
            <th>Description</th>
            <th>Created</th>
            <th>Last Modified</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td><a class="close" href="task/delete?taskId=${task.id}" title="Delete">x</a></td>
                <td>
                    <a href="task?taskId=${task.id}">
                        <c:out value="${task.title}"/>
                    </a>
                </td>
                <td><c:out value="${task.description}"/></td>
                <td>${task.dateCreated}</td>
                <td>${task.dateModified}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
    </c:if>
</body>
</html>