package servlet;

import models.Client;
import models.Country;
import models.User;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CountriesServlet", urlPatterns = "/country")
public class CountriesServlet extends HttpServlet {

    private final CountryService countryService = new CountryServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();
    private final UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String country = req.getParameter("country");
        String login = req.getParameter("login");
        Integer idByLogin = userService.findIdByLogin(login);

        if(clientService.findByHumanId(idByLogin) == null){
            Integer countryId = countryService.findIdByName(country);
            clientService.save(new Client( idByLogin, countryId, 1));
        }
        try {
            req.getRequestDispatcher("Final.html").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


}
