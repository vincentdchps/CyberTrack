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
