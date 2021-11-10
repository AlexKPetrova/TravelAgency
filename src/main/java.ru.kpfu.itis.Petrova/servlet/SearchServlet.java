package servlet;

import service.CountryService;
import service.CountryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "searchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private final CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String search = req.getParameter("search");
        Integer idByName = countryService.findIdByName(search.toLowerCase());
        if(idByName != null){
            String pathCountry = search.toLowerCase() + ".html";
            resp.sendRedirect(pathCountry);
        }else{
            resp.sendRedirect("space.html");
        }
    }

}
