package fr.esgi.manager;

import fr.esgi.DatabaseUtils;
import fr.esgi.dto.Tache;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class TacheManager {

    public void addTache(Tache tache){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(tache);
        session.getTransaction().commit();
        session.close();
    }

    private Tache getTache(String whereClause, Object value){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String sql = "SELECT id, nom FROM Tache " + whereClause;
//        System.out.println("La request : " + sql);
        Query query = session.createQuery(sql);
        query.setParameter("param", value);
        List<Object[]> list = query.list();

        session.close();

        Tache tache = new Tache();
        tache.setId((int)list.get(0)[0]);
        tache.setNom((String)list.get(0)[1]);

        return tache;
    }

    public Tache getTacheByName(String name){
        return getTache("WHERE nom = :param", name);
    }
    public Tache getTacheById(int id){ return getTache("WHERE id = :param", id); }

    // Ca c'est ok mais pas ouf
//    public Tache getTacheById(int id){
//        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        Tache p = session.get(Tache.class, id);
//
//        session.close();
//        return p;
//    }

    public List<Tache> getTaches(){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List tacheList = session.createQuery("FROM Tache").list();
        List<Tache> list = new ArrayList<>();

        for (Object tache : tacheList) {
            list.add((Tache)tache);
        }

        System.out.println("0.6");

        session.getTransaction().commit();
        session.close();
        return list;
    }

}
