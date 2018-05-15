package fr.esgi.dto;

import javax.persistence.*;

@Entity
@Table(name = "priorite")
public class Priorite {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    public Priorite() {}

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
