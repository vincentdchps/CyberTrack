package fr.univ.CyberTrack_backend.service;

import fr.univ.CyberTrack_backend.dao.IncidentDAO;
import fr.univ.CyberTrack_backend.model.Equipement;
import fr.univ.CyberTrack_backend.model.Analyste;
import fr.univ.CyberTrack_backend.model.Incident;
import fr.univ.CyberTrack_backend.repository.AnalysteRepository;
import fr.univ.CyberTrack_backend.repository.EquipementRepository;
import fr.univ.CyberTrack_backend.repository.IncidentRepository;
import java.util.Optional;
import fr.univ.CyberTrack_backend.dto.IncidentDTO;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional ;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
public class IncidentService {

private final IncidentRepository incidentRepository;
private final EquipementRepository equipementRepository;
private final AnalysteRepository analysteRepository;

public IncidentService(IncidentRepository incidentRepository, EquipementRepository equipementRepository,AnalysteRepository analysteRepository){
     this.incidentRepository = incidentRepository;
     this.equipementRepository = equipementRepository;
     this.analysteRepository= analysteRepository;
}


private IncidentDTO toDTO(Incident incident){
    String nomEquipement = incident.getEquipement() !=null ? incident.getEquipement().getNom() : null;
    String nomAnalyste = incident.getAnalyste() !=null ? incident.getAnalyste().getNom() : null ;
    return new IncidentDTO(incident.getId(),incident.getTitre(), incident.getDescription(), incident.getSeverite(), incident.getStatut(), incident.getDateDetection(), nomEquipement, nomAnalyste);}

private Incident toEntity(IncidentDTO dto){
    Equipement equipement = null;
    if(dto.getEquipement() != null){
        equipement = equipementRepository.findByNom(dto.getEquipement()).orElse(null);
    }
    Analyste analyste = null ; 
    if(dto.getAnalyste() !=null){
      analyste = analysteRepository.findByNom(dto.getAnalyste()).orElse(null);
    }
    return new Incident(dto.getId(), dto.getTitre(), dto.getDescription(), dto.getSeverite(), dto.getStatut(), dto.getDateDetection(), equipement, analyste);
}


public List<IncidentDTO> getAll(){
    List<Incident> incidents = incidentRepository.findAll();
    List<IncidentDTO> resultats = new ArrayList<>();
    for(Incident incident : incidents){
       IncidentDTO incidentDTO = toDTO(incident);
        resultats.add(incidentDTO);
    }
    return resultats;
}


public IncidentDTO getById(long id){
   Optional<Incident> incident = incidentRepository.findById(id);

   if (incident.isPresent()) {
       return toDTO(incident.get());
   }

   return null;
}

@Transactional
public IncidentDTO create(IncidentDTO dto){
    Incident incident = toEntity(dto);
    incident = incidentRepository.save(incident);
    return toDTO(incident);

}

@Transactional
public IncidentDTO update(long id, IncidentDTO dto){
    if(incidentRepository.existsById(id)){
        Incident incident = toEntity(dto);
        incident.setId(id);
        incident = incidentRepository.save(incident);
        return toDTO(incident);
    }
    else return null;
}

@Transactional
public boolean delete(long id){
    if(incidentRepository.existsById(id)){
    incidentRepository.deleteById(id);
    return true ;
    }
 return false;
}
}