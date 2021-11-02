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
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String countryOfResidence = req.getParameter("countryOfResidence");
        String citizenship = req.getParameter("citizenship");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String hashPassword = PasswordHelper.encrypt(password);

        //пользователь вводит название страны и гражданство, а в бд будет id этой страны
       // Integer countryOfResidenceId = notNull(countryOfResidence);
        //Integer citizenshipId = notNull(citizenship);

        User user = new User(name, dateOfBirth, 1, 1, login, hashPassword);
        userService.save(user);
        resp.sendRedirect("/persAcc");
    }

    public Integer notNull(String country){
        if(countryService.findIdByName(country) != null){
             return countryService.findIdByName(country);
        }else{
            countryService.save(new Country(country));
            return countryService.findIdByName(country);
        }
    }
}
