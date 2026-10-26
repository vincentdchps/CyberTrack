package fr.univ.CyberTrack.controller;

import fr.univ.CyberTrack.dao.IncidentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private IncidentDAO incidentDAO;

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute("totalIncidents",
                incidentDAO.findAll().size());
        model.addAttribute("nbCritiques",
                incidentDAO.countBySeverite("CRITIQUE"));
        model.addAttribute("nbResolus",
                incidentDAO.countByStatut("RESOLU"));
        model.addAttribute("nbEnCours",
                incidentDAO.countByStatut("EN_COURS"));
        model.addAttribute("incidents",
                incidentDAO.findAll());

        return "dashboard";
        
    }
}