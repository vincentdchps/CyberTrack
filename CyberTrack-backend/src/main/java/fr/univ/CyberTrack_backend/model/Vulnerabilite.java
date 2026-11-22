package fr.univ.CyberTrack_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vulnerabilites")  
public class Vulnerabilite {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String cve;
private String description;
private Double scoreCvss;
@ManyToOne
@JoinColumn(name = "correctif_id")
private Correctif correctif;
@ManyToOne
@JoinColumn(name = "equipement_id")
private Equipement equipement;

    public Vulnerabilite() {
    }

    public Vulnerabilite(Long id, String cve, String description, Double scoreCvss,
                         Correctif correctif, Equipement equipement) {
        this.id = id;
        this.cve = cve;
        this.description = description;
        this.scoreCvss = scoreCvss;
        this.correctif = correctif;
        this.equipement = equipement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getScoreCvss() {
        return scoreCvss;
    }

    public void setScoreCvss(Double scoreCvss) {
        this.scoreCvss = scoreCvss;
    }

    public Correctif getCorrectif() {
        return correctif;
    }

    public void setCorrectif(Correctif correctif) {
        this.correctif = correctif;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

}
