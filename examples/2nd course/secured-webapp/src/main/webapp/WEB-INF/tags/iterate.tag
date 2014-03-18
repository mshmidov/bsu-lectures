<%@tag body-content="scriptless" pageEncoding="UTF-8" %>
<%@attribute name="var" required="true" rtexprvalue="true" %>
<%@attribute name="items" type="java.util.Collection" required="true" %>

<%
    for(Object item : items) {
        request.setAttribute(var, item);
%>
<jsp:doBody/>
<%
    }
%>