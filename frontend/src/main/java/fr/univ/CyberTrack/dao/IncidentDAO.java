package fr.univ.CyberTrack.dao;

import fr.univ.CyberTrack.model.Incident;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class IncidentDAO {

    private Map<Integer, Incident> incidents = new HashMap<>();
    private int nextId = 1;

    public IncidentDAO() {
        add(new Incident(0,
            "Ransomware détecté",
            "Chiffrement de fichiers sur Serveur-Prod-01",
            "CRITIQUE", "EN_COURS",
            LocalDate.of(2026, 10, 1),
            "Serveur-Prod-01", "Vincent Deschamps"));

        add(new Incident(0,
            "Tentative de phishing",
            "Email frauduleux reçu par 3 employés",
            "MOYEN", "OUVERT",
            LocalDate.of(2026, 10, 2),
            "Poste-RH-03", "Alex Martin"));

        add(new Incident(0,
            "Scan de port détecté",
            "Scan réseau externe sur le pare-feu",
            "ÉLEVÉ", "RESOLU",
            LocalDate.of(2026, 9, 28),
            "Firewall-01", "Vincent Deschamps"));
    }

    public void add(Incident i) {
        i.setId(nextId++);
        incidents.put(i.getId(), i);
    }

    public Incident get(int id) {
        return incidents.get(id);
    }

    public List<Incident> findAll() {
        return new ArrayList<>(incidents.values());
    }

    public void update(Incident i) {
        incidents.put(i.getId(), i);
    }

    public void remove(int id) {
        incidents.remove(id);
    }

    public long countBySeverite(String severite) {
        return incidents.values().stream()
                .filter(i -> severite.equals(i.getSeverite()))
                .count();
    }

    public long countByStatut(String statut) {
        return incidents.values().stream()
                .filter(i -> statut.equals(i.getStatut()))
                .count();
    }
}