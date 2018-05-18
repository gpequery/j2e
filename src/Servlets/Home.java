package Servlets;

import fr.esgi.dto.Priorite;
import fr.esgi.dto.Tache;
import fr.esgi.manager.PrioriteManager;
import fr.esgi.manager.TacheManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Home extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
//        TacheManager tacheManager = new TacheManager();
//        List<Tache> taches = tacheManager.getTaches();
//
//        request.setAttribute("taches", taches);
        PrioriteManager prioriteManager = new PrioriteManager();
        List<Priorite> priorites = prioriteManager.getPriorites();

        request.setAttribute("priorites", priorites);

        request.getRequestDispatcher("Views/home.jsp").forward(request, response);
    }
}
