package by.bsu.todo.controllers;

import by.bsu.todo.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sergey Krauchenia
 */
@WebServlet(name = "deleteTaskServlet", urlPatterns = "/task/delete")
public class DeleteTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long taskId = Long.parseLong(req.getParameter("taskId"));

        TaskService taskService = new TaskService();
        taskService.delete(taskId);

        resp.sendRedirect("/tasks");
    }
}
