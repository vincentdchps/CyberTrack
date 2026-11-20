package fr.univ.CyberTrack_backend.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;
    private String severite;  
    private String statut;   
    private LocalDate dateDetection;
    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;
    @ManyToOne
    @JoinColumn(name = "analyste_id")
    private Analyste analyste;

    public Incident() {}

    public Incident(long id, String titre, String description,
                    String severite, String statut,
                    LocalDate dateDetection,
                    Equipement equipement, Analyste analyste) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.severite = severite;
        this.statut = statut;
        this.dateDetection = dateDetection;
        this.equipement = equipement;
        this.analyste = analyste;
    }

    
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

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

    public Equipement getEquipement() { return equipement; }
    public void setEquipement(Equipement equipement) { this.equipement = equipement; }

    public Analyste getAnalyste() { return analyste; }
    public void setAnalyste(Analyste analyste) { this.analyste = analyste; }
}