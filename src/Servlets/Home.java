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
import java.io.PrintWriter;
import java.util.List;

public class Home extends HttpServlet {
    /* AFFICHE LA PAGE */
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        TacheManager tacheManager = new TacheManager();
        List<Tache> taches = tacheManager.getTaches();

        PrioriteManager prioriteManager = new PrioriteManager();
        List<Priorite> priorites = prioriteManager.getPriorites();

        request.setAttribute("taches", taches);
        request.setAttribute("priorites", priorites);

        request.getRequestDispatcher("Views/home.jsp").forward(request, response);
    }

    /* CREER UNE TACHE */
    public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        System.out.println("POST !!");

        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String priorityIdValue = request.getParameter("prioriteId");

//        int prioriteId =  priorityIdValue.isEmpty() ? 0 : (int) Integer.parseInt(priorityIdValue);

        Tache newTache = new Tache(nom, description);

        if(!priorityIdValue.isEmpty()) {
            PrioriteManager prioriteManager = new PrioriteManager();
            Priorite priorite = prioriteManager.getPrioriteById(Integer.parseInt(priorityIdValue));

            newTache.setPriorite(priorite);
        }

        TacheManager tacheManager = new TacheManager();
        tacheManager.addTache(newTache);

        //TODO return true||false pour gerer l'erreur de l'ajout en js sur l'UI ??
        //TODO créer tache créer sans priorite, fix le if ??
    }
}
