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
import java.util.Collection;
import java.util.List;

/**
 * @author Sergey Krauchenia
 */
@WebServlet(name = "taskListServlet", urlPatterns = {"/tasks"})
public class TaskListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService service = new TaskService();
        Collection<Task> tasks = service.getAll();

        // по этому имени список будет доступен на jsp странице task-list.jsp
        req.setAttribute("tasks", tasks);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/task-list.jsp");
        // перенаправляем дальнейшую обработку на jsp-страницу task-list.jsp
        dispatcher.forward(req, resp);
    }
}
