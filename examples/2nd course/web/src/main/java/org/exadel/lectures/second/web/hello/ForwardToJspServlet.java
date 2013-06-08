package org.exadel.lectures.second.web.hello;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author skrauchenia
 */
public class ForwardToJspServlet extends HttpServlet {

    private static final String FORWARD_URL = "/hello-jsp-for-forward-demo.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("nameFromForward", request.getParameter("name"));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(FORWARD_URL);
        dispatcher.forward(request, response);
    }
}
