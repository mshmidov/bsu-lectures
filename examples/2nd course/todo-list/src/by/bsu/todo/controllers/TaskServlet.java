package by.bsu.todo.controllers;

import by.bsu.todo.persistence.model.Task;
import by.bsu.todo.services.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sergey Krauchenia
 */
@WebServlet(name = "taskServlet", urlPatterns = {"/task"})
public class TaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = new TaskService();

        String taskTitle = req.getParameter("taskTitle");
        String id = req.getParameter("id");

        boolean editExistingTask = id != null;

        if (editExistingTask) {
            String description = req.getParameter("description");
            taskService.update(Long.parseLong(id), taskTitle, description);
        } else {
            taskService.createNew(taskTitle);
        }

        resp.sendRedirect("/tasks");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long taskId = Long.parseLong(req.getParameter("taskId"));
        TaskService taskService = new TaskService();

        Task task = taskService.getById(taskId);
        req.setAttribute("taskForEdit", task);

        RequestDispatcher dispatch = req.getRequestDispatcher("/WEB-INF/task-edit.jsp");
        dispatch.forward(req, resp);
    }
}
