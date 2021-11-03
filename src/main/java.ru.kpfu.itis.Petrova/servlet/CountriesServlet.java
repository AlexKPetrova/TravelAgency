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
import java.util.List;

@WebServlet(name = "CountriesServlet", urlPatterns = "/countries")
public class CountriesServlet extends HttpServlet {


    private final UserService userService = new UserServiceImpl();
    private final CountryService countryService = new CountryServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Country> countryList = countryService.findAll();
        //todo как передать лист на фронт?
        //меню с выбором стран ( они вытаскиваются из бд)
        resp.sendRedirect("");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String countryReservation = req.getParameter("countryReservation");
        String id = req.getParameter("id");
        Integer idInt = (new Integer(id));

        if(clientService.findByHumanId(idInt) == null){
            Integer countryId = countryService.findIdByName(countryReservation);
            clientService.save(new Client(idInt,countryId));
        }
        try {
            req.getRequestDispatcher("/tours").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


}
