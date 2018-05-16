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
        request.getRequestDispatcher("Views/home.jsp").forward(request, response);

        PrioriteManager prioriteManager = new PrioriteManager();
        TacheManager tacheManager = new TacheManager();

        System.out.println("======================================================");
        System.out.println("0");
        List<Priorite> priorites = prioriteManager.getPriorites();
        System.out.println("0.5");
        List<Tache> taches = tacheManager.getTaches();

        /* TODO Jveux insert des taches dans ta bdd :'( */
        Tache newTache = new Tache("Tache De Greg", "Jolie Tâche", priorites.get(0));
        System.out.println("1");
        tacheManager.addTache(newTache);

        for (Priorite priorite : priorites) {
            System.out.println(priorite);
        }

        for (Tache tache : taches) {
            System.out.println(tache);
        }


        System.out.println("======================================================");
    }
}
