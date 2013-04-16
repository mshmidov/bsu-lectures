<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <div id="content">
            <table>
                <c:forEach items="${passedStudents}" var="passedStudent">
                    <tr>
                        <td>${passedStudent}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>