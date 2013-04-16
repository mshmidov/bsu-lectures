<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        table.tftable {
            font-size: 12px;
            color: #333333;
            width: 20%;
            border: 1px #729ea5;
            border-collapse: collapse;
        }

        table.tftable th {
            font-size: 12px;
            background-color: #acc8cc;
            padding: 8px;
            border: 1px solid #729ea5;
            text-align: left;
        }

        table.tftable tr {
            background-color: #d4e3e5;
        }

        table.tftable td {
            font-size: 12px;
            padding: 8px;
            border: 1px solid #729ea5;
        }
    </style>

    <!-- Row Highlight Javascript -->
    <script type="text/javascript">
        window.onload = function() {
            var tfrow = document.getElementById('tfhover').rows.length;
            var tbRow = [];
            for(var i = 1; i < tfrow; i++) {
                tbRow[i] = document.getElementById('tfhover').rows[i];
                tbRow[i].onmouseover = function() {
                    this.style.backgroundColor = '#ffffff';
                };
                tbRow[i].onmouseout = function() {
                    this.style.backgroundColor = '#d4e3e5';
                };
            }
        };
    </script>
</head>
<body>
<div style="margin-left: 30px;">
    <table id="tfhover" class="tftable" border="1">
        <tr>
            <th>Student id</th>
            <th>Time</th>
        <c:if test="${empty passedStudents}">
        <tr>
            <td colspan="2">Anybody?</td>
        </tr>
        </c:if>
        <c:forEach items="${passedStudents}" var="passedStudent">
        <tr>
            <td>${passedStudent.key}</td>
            <td>${passedStudent.value}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>