package fr.univ.CyberTrack.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fr.univ.CyberTrack.model.Incident;

@Repository
public class IncidentDAO {

    private Map<Integer, Incident> incidents = new HashMap<>();
    private int nextId = 1;

    public IncidentDAO() {
        add(new Incident(0,
            "Virus détecté",
            "",
            "CRITIQUE", "EN_COURS",
            LocalDate.of(2026, 10, 1),
            "Serveur-1", "Vincent"));

        add(new Incident(0,
            "Phishing",
            "",
            "MOYEN", "OUVERT",
            LocalDate.of(2026, 10, 2),
            "Windows-2", "Axel"));

        add(new Incident(0,
            "Scan de ports détecté",
            "",
            "ÉLEVÉ", "RESOLU",
            LocalDate.of(2026, 9, 28),
            "Firewall-4", "Vincent"));
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