package fr.univ.CyberTrack_backend.dao;
import fr.univ.CyberTrack_backend.model.Incident;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


@Repository 
public class IncidentDAO {

    Map<Long, Incident> incidents = new HashMap<>();
    private long nextId = 4L;

    public IncidentDAO() {
        save(new Incident(1, "Incident 1", "Description de l'incident 1", "CRITIQUE", "EN_COURS", LocalDate.of(2026, 10, 1), "Serveur-1", "Vincent"));
        save(new Incident(2, "Incident 2", "Description de l'incident 2", "MOYEN", "OUVERT", LocalDate.of(2026, 10, 2), "Windows-2", "Axel"));
        save(new Incident(3, "Incident 3", "Description de l'incident 3", "ÉLEVÉ", "RESOLU", LocalDate.of(2026, 9, 28), "Firewall-4", "Vincent"));
    }

    public Incident save(Incident incident) {
        if(incident.getId() == 0){
            incident.setId((int) nextId++);
        }
         incidents.put((long) incident.getId(), incident);
         return incident;
    }

    public List<Incident> findAll() {
    return new ArrayList<>(incidents.values());
    }

    public Incident findById(long id) {
         return incidents.get(id);
}

public boolean delete(long id){
    if(incidents.containsKey(id)) {
     incidents.remove(id);
     return true ;
    }
    return false; 
}
    
}
