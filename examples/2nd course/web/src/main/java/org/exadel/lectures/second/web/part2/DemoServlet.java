package org.exadel.lectures.second.web.part2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author skrauchenia
 */
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Person person = new Person();
        if (id != null) {
            person = getPersonById(Integer.parseInt(id));
        }
        request.setAttribute("person", person);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Construct object from parameter
        Person person = new Person();
        String id = request.getParameter("personId");
        person.setId(Integer.parseInt(id));
        person.setFirstName(request.getParameter("personFirstName"));
        person.setLastName(request.getParameter("personLastName"));

        //TODO: save the object in the DB/XML file/etc.

        request.setAttribute("person", person);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/result.jsp");
        dispatcher.forward(request, response);
    }

    private Person getPersonById(Integer id) {
        //TODO: you can get it from the DB/XML/etc
        Person person = new Person();
        person.setId(id);
        person.setFirstName("First Name" + id);
        person.setLastName("Last Name" + id);

        return person;
    }
}
