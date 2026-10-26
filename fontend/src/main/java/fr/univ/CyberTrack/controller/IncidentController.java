package fr.univ.CyberTrack.controller;

import fr.univ.CyberTrack.dao.IncidentDAO;
import fr.univ.CyberTrack.model.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/incidents")
public class IncidentController {

    @Autowired
    private IncidentDAO incidentDAO;

    // Liste [4]
    @GetMapping
    public String liste(Model model) {
        model.addAttribute("incidents", incidentDAO.findAll());
        return "listeIncidents";
    }

    // Détail [4]
    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("incident", incidentDAO.get(id));
        return "detailIncident";
    }

    // Formulaire création
    @GetMapping("/new")
    public String nouveauFormulaire(Model model) {
        model.addAttribute("incident", new Incident());
        return "formulaireIncident";
    }

    // Formulaire modification
    @GetMapping("/{id}/edit")
    public String modifierFormulaire(@PathVariable int id, Model model) {
        model.addAttribute("incident", incidentDAO.get(id));
        return "formulaireIncident";
    }

    // Traitement ajout/modification POST [6]
    @PostMapping("/save")
    public String sauvegarder(
            @RequestParam(required = false) Integer id,
            @RequestParam String titre,
            @RequestParam String description,
            @RequestParam String severite,
            @RequestParam String statut,
            @RequestParam String equipement,
            @RequestParam String analyste) {

        if (id == null || id == 0) {
            // Création
            Incident i = new Incident(0, titre, description,
                    severite, statut, LocalDate.now(),
                    equipement, analyste);
            incidentDAO.add(i);
        } else {
            // Modification
            Incident i = incidentDAO.get(id);
            i.setTitre(titre);
            i.setDescription(description);
            i.setSeverite(severite);
            i.setStatut(statut);
            i.setEquipement(equipement);
            i.setAnalyste(analyste);
            incidentDAO.update(i);
        }
        // redirect : pattern POST-Redirect-GET [6]
        return "redirect:/incidents";
    }

    // Suppression
    @GetMapping("/{id}/delete")
    public String supprimer(@PathVariable int id) {
        incidentDAO.remove(id);
        return "redirect:/incidents";
    }
}