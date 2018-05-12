package fr.esgi.dto;

public class TacheDTO {

    private int id;
    private String nom;
    private String description;
    private PrioriteDTO prioriteDTO;

    public TacheDTO(int id, String nom, String description, PrioriteDTO prioriteDTO) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prioriteDTO = prioriteDTO;
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

    public PrioriteDTO getPrioriteDTO() {
        return prioriteDTO;
    }

    public void setPrioriteDTO(PrioriteDTO prioriteDTO) {
        this.prioriteDTO = prioriteDTO;
    }
}
