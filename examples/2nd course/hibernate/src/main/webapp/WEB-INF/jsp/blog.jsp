<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple blog</title>
</head>
<body>

    <h1>My Simplest Blog</h1>

    <form action="/blog/post" method="post">

        <label>
            Name
            <input type="text" name="name" />
        </label>

        <label>
            Text
            <input type="text" name="text" />
        </label>

        <input type="submit" value="Create new post">
    </form>

    <hr>

    <s:forEach items="${posts}" var="post">
        <article>
            <h1><a href="/blog/post/${post.id}"><s:out value="${post.name}" /></a></h1>
            <p><s:out value="${post.text}" /></p>



            <form action="/blog/post/${post.id}/delete" method="post">
               <input type="submit" value="delete post" />

            </form>
        </article>
        <hr>
    </s:forEach>

</body>
</html>
