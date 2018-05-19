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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TacheManager tacheManager = new TacheManager();
        List<Tache> taches = tacheManager.getTaches();

        PrioriteManager prioriteManager = new PrioriteManager();
        List<Priorite> priorites = prioriteManager.getPriorites();

        request.setAttribute("taches", taches);
        request.setAttribute("priorites", priorites);

        request.getRequestDispatcher("Views/home.jsp").forward(request, response);
    }

    /* SWITCH ACTION */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] params = request.getRequestURI().split("/");

        String action = params[params.length - 1];

        System.out.println(action);

        switch (action) {
            case "create":
                this.createTache(request, response);
                break;
            case "delete":
                this.deleteTache(request, response);
                break;
        }


    }

    //TODO tache créer sans priorite??
    /* CREER TACHE */
    private void createTache(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String priorityIdValue = request.getParameter("prioriteId");

        Tache newTache = new Tache(nom, description);

        if(!priorityIdValue.isEmpty()) {
            System.out.println("id : " + priorityIdValue);

            PrioriteManager prioriteManager = new PrioriteManager();
            Priorite priorite = prioriteManager.getPrioriteById(Integer.parseInt(priorityIdValue));

            newTache.setPriorite(priorite);
        }

        TacheManager tacheManager = new TacheManager();
        tacheManager.addTache(newTache);

        PrintWriter out = response.getWriter();
        out.print(newTache.getId());
    }

    /* SUPPRIMER TACHE */
    private void deleteTache(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tacheId = Integer.parseInt(request.getParameter("id"));

        TacheManager tacheManager = new TacheManager();
        tacheManager.deleteTache(tacheId);

        PrintWriter out = response.getWriter();
        out.print("<h1>ok</h1>");
    }
}
