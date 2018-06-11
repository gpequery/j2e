package fr.esgi.dto;

import javax.persistence.*;

@Entity
@Table(name = "TACHE")
public class Tache {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PRIORITE_ID", referencedColumnName = "ID", insertable = true, updatable = true)
    private Priorite priorite;

    public Tache() {
    }

    public Tache(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Tache(int id) {
        this.id = id;
    }

    public Tache(String nom, String description, Priorite priorite) {
        this.nom = nom;
        this.description = description;
        this.priorite = priorite;
    }

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
