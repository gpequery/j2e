package fr.esgi.dto;

import javax.persistence.*;

@Entity
@Table(name = "tache")
public class Tache {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "id")
    private Priorite priorite;

    public Tache() {}

    public Tache(int id, String nom, String description, Priorite priorite) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.priorite = priorite;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", priorite=" + priorite +
                '}';
    }
}
