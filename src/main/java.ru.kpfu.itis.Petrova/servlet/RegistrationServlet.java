package servlet;

import DTO.UserDTO;
import models.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService;


    public RegistrationServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo путь до файла с регистрацией, начальный, как у входа
        req.getServletContext().getRequestDispatcher("").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String countryOfResidence = req.getParameter("countryOfResidence");
        String citizenship = req.getParameter("citizenship");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

       // User user = new UserDTO(name,dateOfBirth,countryOfResidence,citizenship,login,password);

        userService.save(user);
        doGet(req, resp);
        //todo путь до профиля файл с версткой
        req.getServletContext().getRequestDispatcher("").forward(req, resp);
    }
}
