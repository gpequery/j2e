package fr.esgi.dto;

import javax.persistence.*;

@Entity
@Table(name = "priorite")
public class Priorite {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "priorite_id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "val")
    private float val;

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

    public float getValue() {
        return val;
    }

    public void setValue(float value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return "Priorite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", val=" + val +
                '}';
    }
}
