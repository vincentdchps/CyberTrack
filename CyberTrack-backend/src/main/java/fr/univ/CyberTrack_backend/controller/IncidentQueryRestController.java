package fr.univ.CyberTrack_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.List;
import fr.univ.CyberTrack_backend.model.Incident;
import fr.univ.CyberTrack_backend.repository.IncidentRepository;

@RestController
@RequestMapping("/api/test-queries")
public class IncidentQueryRestController {

    private final IncidentRepository incidentRepository;

    public IncidentQueryRestController(IncidentRepository incidentRepository){
        this.incidentRepository = incidentRepository ;
    }

@GetMapping("/by-titre")
public ResponseEntity<Incident> getByTitre(@RequestParam String titre) {
    Optional<Incident> resultat = incidentRepository.findByTitre(titre);
    if (resultat.isPresent()) {
        return ResponseEntity.ok(resultat.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}

@GetMapping("/by-titre-jpql")
public ResponseEntity<Incident> getByTitreJPQL(@RequestParam String titre) {
    Optional<Incident> resultat = incidentRepository.findByTitreJPQL(titre);
    if (resultat.isPresent()) {
        return ResponseEntity.ok(resultat.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}

@GetMapping("/by-statut-severite")
public List<Incident> getByStatutAndSeverite(@RequestParam String statut, @RequestParam String severite) {
    return incidentRepository.findByStatutAndSeverite(statut, severite);
}


@GetMapping("/by-statut-severite-jpql")
public List<Incident> getByStatutAndSeveriteJPQL(@RequestParam String statut, @RequestParam String severite) {
    return incidentRepository.findByStatutAndSeveriteJPQL(statut, severite);
}

@GetMapping("/count-by-statut")
public long countByStatut(@RequestParam String statut) {
    return incidentRepository.countByStatut(statut);
}

@GetMapping("/count-by-statut-jpql")
public long countByStatutJPQL(@RequestParam String statut) {
    return incidentRepository.countByStatutJPQL(statut);
}

@GetMapping("/exists-by-titre")
public boolean existsByTitre(@RequestParam String titre) {
    return incidentRepository.existsByTitre(titre);
}

@GetMapping("/exists-by-titre-jpql")
public boolean existsByTitreJPQL(@RequestParam String titre) {
    return incidentRepository.existsByTitreJPQL(titre);
}

@GetMapping("/by-equipement")
public List<Incident> getByEquipement(@RequestParam String nom) {
    return incidentRepository.findByEquipementNom(nom);
}

@GetMapping("/by-equipement-jpql")
public List<Incident> getByEquipementJPQL(@RequestParam String nom) {
    return incidentRepository.findByEquipementNomJPQL(nom);
}

}
