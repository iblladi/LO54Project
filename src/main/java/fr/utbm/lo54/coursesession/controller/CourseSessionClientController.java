package fr.utbm.lo54.coursesession.controller;

import fr.utbm.lo54.coursesession.entity.Client;
import fr.utbm.lo54.coursesession.entity.CourseSession;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import fr.utbm.lo54.coursesession.metier.CourseSessionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class CourseSessionClientController {

    @Autowired
    private ClientMetier clientMetier;

    @Autowired
    private CourseSessionMetier courseSessionMetier;

    @RequestMapping(value = "/validate",method = RequestMethod.GET)
    public String preInscription(Model model, Principal p, Long id, final RedirectAttributes redirectAttributes){


        Client c =clientMetier.findByEmail(p.getName());

        CourseSession cs = courseSessionMetier.findOne(id);

        if ((p.getName().equals(clientMetier.searchRegistredInSession(c.getId(),cs.getId())))){
            model.addAttribute("message", "Déjà Inscrit");
            return "erreurs/erreur";
        }

        c.getCourseSessions().add(cs);

        cs.getClients().add(c);

        if(cs.getNbrestants() == 0){
            model.addAttribute("message", "Plus de places disponibles");
            return "erreurs/erreur";
        }

        cs.setNbrestants(cs.getNbrestants() - 1);

        clientMetier.updateClient(c);

        redirectAttributes.addFlashAttribute("message","Pré-inscription à la formation "+cs.getCourse().getTitle()+" a été effectué avec succès.");

        return "redirect:MyCourseSessionCart";
    }
}
