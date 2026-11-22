package fr.univ.CyberTrack_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univ.CyberTrack_backend.model.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long>{
 Optional<Equipement> findByNom(String nom);
}
