package fr.univ.CyberTrack.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.univ.CyberTrack.dao.IncidentDAO;
import fr.univ.CyberTrack.model.Incident;

@Controller
@RequestMapping("/incidents")
public class IncidentController {

    @Autowired
    private IncidentDAO incidentDAO;

    @GetMapping
    public String liste(Model model) {
        model.addAttribute("incidents", incidentDAO.findAll());
        return "listeIncidents";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("incident", incidentDAO.get(id));
        return "detailIncident";
    }

    @GetMapping("/new")
    public String nouveauFormulaire(Model model) {
        model.addAttribute("incident", new Incident());
        return "formulaireIncident";
    }

    @GetMapping("/{id}/edit")
    public String modifierFormulaire(@PathVariable int id, Model model) {
        model.addAttribute("incident", incidentDAO.get(id));
        return "formulaireIncident";
    }
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
            Incident i = new Incident(0, titre, description,
                    severite, statut, LocalDate.now(),
                    equipement, analyste);
            incidentDAO.add(i);
        } else {
            Incident i = incidentDAO.get(id);
            i.setTitre(titre);
            i.setDescription(description);
            i.setSeverite(severite);
            i.setStatut(statut);
            i.setEquipement(equipement);
            i.setAnalyste(analyste);
            incidentDAO.update(i);
        }
        return "redirect:/incidents";
    }

    @GetMapping("/{id}/delete")
    public String supprimer(@PathVariable int id) {
        incidentDAO.remove(id);
        return "redirect:/incidents";
    }
}