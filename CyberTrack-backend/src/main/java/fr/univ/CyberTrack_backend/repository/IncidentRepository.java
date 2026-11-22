package fr.univ.CyberTrack_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.univ.CyberTrack_backend.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

Optional<Incident> findByTitre(String titre); 

@Query("SELECT i FROM Incident i WHERE i.titre = :titre")
Optional<Incident> findByTitreJPQL(@Param("titre") String titre);

List<Incident> findByStatutAndSeverite(String statut, String severite); 

@Query("SELECT i FROM Incident i WHERE i.statut = :statut AND i.severite = :severite")
List<Incident> findByStatutAndSeveriteJPQL(@Param("statut") String statut, @Param("severite") String severite); 

long countByStatut(String statut); 

@Query("SELECT COUNT(i) FROM Incident i WHERE i.statut = :statut")
long countByStatutJPQL(@Param("statut") String statut); 


boolean existsByTitre(String titre);

@Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM Incident i WHERE i.titre = :titre")
boolean existsByTitreJPQL(@Param("titre") String titre); 

List<Incident> findByEquipementNom(String nom); 

@Query("SELECT i FROM Incident i WHERE i.equipement.nom = :nom")
List<Incident> findByEquipementNomJPQL(@Param("nom") String nom);
}

