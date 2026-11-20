package fr.univ.CyberTrack_backend.service;

import fr.univ.CyberTrack_backend.dao.IncidentDAO;
import fr.univ.CyberTrack_backend.model.Incident;
import fr.univ.CyberTrack_backend.dto.IncidentDTO;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IncidentService {

private final IncidentDAO dao;

public IncidentService(IncidentDAO dao){
     this.dao = dao ;
}


private IncidentDTO toDTO(Incident incident){
    return new IncidentDTO(incident.getId(),incident.getTitre(), incident.getDescription(), incident.getSeverite(), incident.getStatut(), incident.getDateDetection(), incident.getEquipement(), incident.getAnalyste());}

private Incident toEntity(IncidentDTO dto){
    return new Incident(dto.getId(), dto.getTitre(), dto.getDescription(), dto.getSeverite(), dto.getStatut(), dto.getDateDetection(), dto.getEquipement(), dto.getAnalyste());
}


public List<IncidentDTO> getAll(){
    List<Incident> incidents = dao.findAll();
    List<IncidentDTO> resultats = new ArrayList<>();
    for(Incident incident : incidents){
       IncidentDTO incidentDTO = toDTO(incident);
        resultats.add(incidentDTO);
    }
    return resultats;
}


public IncidentDTO getById(long id){
   Incident incident =  dao.findById(id);
   if(incident != null){
   return toDTO(incident);
   }
   else return null;
}

public IncidentDTO create(IncidentDTO dto){
    Incident incident = toEntity(dto);
    incident = dao.save(incident);
    return toDTO(incident);

}

public IncidentDTO update(long id, IncidentDTO dto){
    if(dao.findById(id) !=null){
        Incident incident = toEntity(dto);
        incident.setId((int) id);
        incident = dao.save(incident);
        return toDTO(incident);
    }
    else return null;
}

public boolean delete(long id){
return dao.delete(id);
}
}