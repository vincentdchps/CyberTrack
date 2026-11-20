package fr.univ.CyberTrack_backend.dto;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class IncidentDTO {
    private long id;
    @NotBlank (message = "Le titre est obligatoire")
    private String titre;
    private String description;
    @NotBlank (message = "La sévérité est obligatoire")
    private String severite;
    @NotBlank (message = "Le statut est obligatoire")
    private String statut;
    private LocalDate dateDetection;
    private String equipement;
    private String analyste;

    public IncidentDTO() {}

    public IncidentDTO(long id, String titre, String description, String severite, String statut, LocalDate dateDetection, String equipement, String analyste) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.severite = severite;
        this.statut = statut;
        this.dateDetection = dateDetection;
        this.equipement = equipement;
        this.analyste = analyste;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverite() {
        return severite;
    }

    public void setSeverite(String severite) {
        this.severite = severite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDate getDateDetection() {
        return dateDetection;
    }

    public void setDateDetection(LocalDate dateDetection) {
        this.dateDetection = dateDetection;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    public String getAnalyste() {
        return analyste;
    }

    public void setAnalyste(String analyste) {
        this.analyste = analyste;
    }
}
