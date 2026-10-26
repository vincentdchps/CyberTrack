package fr.univ.CyberTrack.model;

import java.time.LocalDate;

public class Incident {

    private int id;
    private String titre;
    private String description;
    private String severite;  // CRITIQUE / ÉLEVÉ / MOYEN / FAIBLE
    private String statut;    // OUVERT / EN_COURS / RESOLU
    private LocalDate dateDetection;
    private String equipement;
    private String analyste;

    public Incident() {}

    public Incident(int id, String titre, String description,
                    String severite, String statut,
                    LocalDate dateDetection,
                    String equipement, String analyste) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.severite = severite;
        this.statut = statut;
        this.dateDetection = dateDetection;
        this.equipement = equipement;
        this.analyste = analyste;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeverite() { return severite; }
    public void setSeverite(String severite) { this.severite = severite; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public LocalDate getDateDetection() { return dateDetection; }
    public void setDateDetection(LocalDate dateDetection) { this.dateDetection = dateDetection; }

    public String getEquipement() { return equipement; }
    public void setEquipement(String equipement) { this.equipement = equipement; }

    public String getAnalyste() { return analyste; }
    public void setAnalyste(String analyste) { this.analyste = analyste; }
}