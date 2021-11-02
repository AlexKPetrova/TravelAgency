package servlet;

import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("authorization.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        String hashPassword = PasswordHelper.encrypt(password);


        if (userService.isLogin(login,hashPassword)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", login);

            session.setMaxInactiveInterval(60 * 60);

            Cookie loginCookie = new Cookie("userLogin", login);
            Cookie passCookie = new Cookie("userPassword", password);
            Cookie rememberCookie = new Cookie("userRemember", remember);

            loginCookie.setMaxAge(24 * 60 * 60);
            passCookie.setMaxAge(24*60*60);
            rememberCookie.setMaxAge(24*60*60);

            resp.addCookie(loginCookie);
            resp.addCookie(passCookie);
            resp.addCookie(rememberCookie);

            resp.sendRedirect("/persAcc");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
