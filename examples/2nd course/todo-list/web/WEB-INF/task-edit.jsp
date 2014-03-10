<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tasks Edit</title>

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="http://code.jquery.com/jquery-2.1.0.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="row-fluid col-md-3">
<form action="task" method="POST">
    <input type="hidden" name="id" value="${taskForEdit.id}"/>
    <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" name="taskTitle" value="${taskForEdit.title}">
    </div>
    <div class="form-group">
        <label for="desc">Password</label>
        <textarea id="desc" name="description" class="form-control"><c:out value="${taskForEdit.description}"/></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</div>
</body>
</html>