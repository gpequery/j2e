package fr.esgi.dto;

import javax.persistence.*;

@Entity
@Table(name = "PRIORITE")
public class Priorite {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOM")
    private String nom;

    public Priorite() {
    }

    public Priorite(String nom) {
        this.nom = nom;
    }

    public Priorite(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Priorite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
