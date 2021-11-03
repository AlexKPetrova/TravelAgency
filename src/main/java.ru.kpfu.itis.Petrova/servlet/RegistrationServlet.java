package servlet;

import models.Country;
import models.User;
import service.CountryService;
import service.CountryServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // путь до файла с регистрацией, начальный, как у входа
        resp.sendRedirect("registration.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String hashPassword = PasswordHelper.encrypt(password);

        User user = new User(1, 1, login, hashPassword);
        userService.save(user);
        resp.sendRedirect("/login");
    }

}
