package servlet;

import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

   private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("authorization.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        int hashCodePass = password.hashCode();

        if (userService.isLogin(login,hashCodePass)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", login);
            // путь до главной странички - страничи пользователя
            req.getServletContext().getRequestDispatcher("/").forward(req, resp);
        } else {
            resp.sendRedirect("authorization.html");
        }
    }
}
