package fr.univ.CyberTrack_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.univ.CyberTrack_backend.model.Analyste;

@Repository
public interface AnalysteRepository extends JpaRepository<Analyste, Long> {
    Optional<Analyste> findByNom(String nom);
}