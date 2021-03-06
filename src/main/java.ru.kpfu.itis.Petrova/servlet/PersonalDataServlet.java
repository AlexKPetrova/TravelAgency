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


@WebServlet(name = "PersonalDataServlet", urlPatterns = "/dateUpdate")
public class PersonalDataServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //страничка с полями для ввода личной информации
        resp.sendRedirect("UpdateDate.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        Integer idByLogin = userService.findIdByLogin(login);
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String countryOfResidence = req.getParameter("countryOfResidence");
        String citizenship = req.getParameter("citizenship");

        //Пользователь вводит название страны, оно ищется в бд, в случае отсутсвия добавляется
        //озвращает из бд id
        Integer countryOfResidenceId = notNull(countryOfResidence);
        Integer citizenshipId = notNull(citizenship);

        User user = new User(idByLogin, name,dateOfBirth,countryOfResidenceId,citizenshipId);
        userService.update(user);
        resp.sendRedirect("basic.html");
    }

    public Integer notNull(String country){

        if (countryService.findIdByName(country) == null) {
            countryService.save(new Country(country));
        }
        return countryService.findIdByName(country);
    }


}
