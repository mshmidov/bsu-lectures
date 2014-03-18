<%@tag body-content="scriptless" pageEncoding="UTF-8" %>
<%@attribute name="rolesAllowed" required="true" rtexprvalue="true" type="java.lang.String" %>

<%
    String[] roles = rolesAllowed.split(",");
    boolean allowed = false;
    for(String role : roles) {
        if(request.isUserInRole(role)) {
            allowed = true;
            break;
        }
    }

    if(allowed) {
%>
<jsp:doBody/>
<%
    }
%>
