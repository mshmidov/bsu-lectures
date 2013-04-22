<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><s:out value="${post.name}"/></title>
</head>
<body>

    <h1><s:out value="${post.name}"/></h1>

    <p><s:out value="${post.text}"/></p>

    <form action="/blog/post/${post.id}/comment" method="post">

        <label>
            Author
            <input type="text" name="author" />
        </label>

        <label>
            Text
            <input type="text" name="text" />
        </label>

        <input type="submit" value="add comment" />
    </form>

    <hr>
    <s:forEach items="${post.comments}" var="comment">
        <article>
            <h1>${comment.author}</h1>
            <p>${comment.text}</p>
            <hr>
        </article>
    </s:forEach>
</body>
</html>