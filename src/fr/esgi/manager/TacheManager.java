package fr.esgi.manager;

import fr.esgi.DatabaseUtils;
import fr.esgi.dto.Priorite;
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

        String sql = "SELECT t.id, t.nom FROM Tache t";
        sql += " INNER JOIN Priorite p ON t.priorite = p.id ";
        sql += whereClause;
        sql += " ORDER BY p.val";
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
        return getTache("WHERE t.nom = :param", name);
    }
    public Tache getTacheById(int id){ return getTache("WHERE t.id = :param", id); }

    public List<Tache> getTaches(){
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List tacheList = session.createQuery("FROM Tache").list();
        List<Tache> list = new ArrayList<>();

        for (Object tache : tacheList) {
            list.add((Tache)tache);
        }

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void deleteTache(int tacheId) {
        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(new Tache(tacheId));
        session.getTransaction().commit();
        session.close();
    }

    public void updateTache(int tacheId, String newNom, String newDescription, Priorite newPriorite) {
        Tache tache = this.getTacheById(tacheId);

        tache.setNom(newNom);
        tache.setDescription(newDescription);
        tache.setPriorite(newPriorite);

        Session session = DatabaseUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(tache);
        session.getTransaction().commit();
        session.close();
    }
}
