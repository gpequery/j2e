package fr.esgi.manager;

import fr.esgi.DatabaseUtils;
import fr.esgi.dto.Priorite;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class PrioriteManager {

    public void addPriorite(Priorite priorite){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(priorite);
        session.getTransaction().commit();
        session.close();
    }

    private Priorite getPriorite(String value){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String sql = "SELECT  Priorite.id, Priorite.nom FROM Priorite " + value;
        Query query = session.createQuery(sql);
        List results = query.list();

        session.close();
        return (Priorite)results.get(0);
    }

    public Priorite getPrioriteByName(String name){
        return getPriorite("WHERE Priorite.nom = " + name);
    }

    public Priorite getPrioriteById(int id){
//        return getPriorite("WHERE Priorite.id = " + String.valueOf(id));
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String sql = "SELECT  P.id, P.nom FROM Priorite P WHERE Priorite.id = 3";
        Query query = session.createQuery(sql);
        List results = query.list();

        session.close();
        return (Priorite)results.get(0);
    }

    // Ca c'est ok mais pas ouf
//    public Priorite getPrioriteById(int id){
//        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        Priorite p = session.get(Priorite.class, id);
//
//        session.close();
//        return p;
//    }

    public List<Priorite> getPriorites(){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List prioritesList = session.createQuery("FROM Priorite").list();
        List<Priorite> list = new ArrayList<>();

        for (Object priorite : prioritesList) {
            list.add((Priorite)priorite);
        }

        session.getTransaction().commit();
        session.close();
        return list;
    }

}
