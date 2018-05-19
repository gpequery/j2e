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

    private Priorite getPriorite(String whereClause, Object value){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String sql = "SELECT id, nom FROM Priorite " + whereClause;
//        System.out.println("La request : " + sql);
        Query query = session.createQuery(sql);
        query.setParameter("param", value);
        List<Object[]> list = query.list();

        session.close();

        Priorite p = new Priorite();
        p.setId((int)list.get(0)[0]);
        p.setNom((String)list.get(0)[1]);

        return p;
    }

    public Priorite getPrioriteByName(String name){
        return getPriorite("WHERE nom = :param", name);
    }
    public Priorite getPrioriteById(int id){ return getPriorite("WHERE id = :param", id); }

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

        List prioritesList = session.createQuery("FROM Priorite order by nom").list();
        List<Priorite> list = new ArrayList<>();

        for (Object priorite : prioritesList) {
            list.add((Priorite)priorite);
        }

        session.getTransaction().commit();
        session.close();
        return list;
    }

}
