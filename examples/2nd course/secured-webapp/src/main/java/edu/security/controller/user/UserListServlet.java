package edu.security.controller.user;

import edu.security.entity.User;
import edu.security.service.UserService;
import edu.security.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@ServletSecurity(
        value = @HttpConstraint(
                value = ServletSecurity.EmptyRoleSemantic.PERMIT,
                rolesAllowed = {
                        "admin",
                        "user"
                }
        )
)
@WebServlet(urlPatterns = "/user/list")
public class UserListServlet extends HttpServlet {
    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users = userService.getAllUsers();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}
