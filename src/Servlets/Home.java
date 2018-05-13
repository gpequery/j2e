package Servlets;

import fr.esgi.dto.Priorite;
import fr.esgi.manager.PrioriteManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Home extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher("Views/home.jsp").forward(request, response);

        PrioriteManager pm = new PrioriteManager();

        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        Priorite urgente = new Priorite("Urgent lol");
        Priorite majeur = new Priorite("Majeur lol");
        Priorite mineur = new Priorite("Mineur lol");

//        pm.addPriorite(urgente);
//        pm.addPriorite(majeur);
//        pm.addPriorite(mineur);

        pm.getPriorites();

        System.out.println("======================================================");

        Priorite p = pm.getPrioriteById(3);
        System.out.println("Id : " + p.getId() + ", nom : " + p.getNom());

        p = pm.getPrioriteByName("Urgent");
        System.out.println("Id : " + p.getId() + ", nom : " + p.getNom());
    }
}
