package fr.utbm.lo54.coursesession.controller;

import fr.utbm.lo54.coursesession.entity.Client;
import fr.utbm.lo54.coursesession.entity.CourseSession;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import fr.utbm.lo54.coursesession.metier.CourseSessionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

        /*if(p.getName() == null){
            model.addAttribute("client", new Client());
            return "form/registration";
        }*/ //Registration + PreInscription same time


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

    @RequestMapping(value= "/inscrCliSess", method = RequestMethod.GET)
    public String inscrCliSess(Model model, Long id){
        CourseSession crs = courseSessionMetier.findOne(id);
        model.addAttribute("client", new Client());
        model.addAttribute("crs",crs.getId());
        return "form/inscrCliSess";
    }

    @RequestMapping(value="/preInsc",method=RequestMethod.POST)
    public String preInsc(Model model, @ModelAttribute("client") Client cl, @RequestParam("id")  Long id, final RedirectAttributes redirectAttributes){
        if (clientMetier.clientExists(cl)) {
            model.addAttribute("message", "Email/Client déjà existant");
            return "erreurs/erreur";
        }
        CourseSession crs = courseSessionMetier.findOne(id);
        cl.getCourseSessions().add(crs);

        crs.getClients().add(cl);

        if(crs.getNbrestants() == 0){
            model.addAttribute("message", "Plus de places disponibles");
            return "erreurs/erreur";
        }

        crs.setNbrestants(crs.getNbrestants() - 1);
        clientMetier.saveClient(cl);
        redirectAttributes.addFlashAttribute("message","Pré-inscription à la formation "+crs.getCourse().getTitle()+" a été effectué avec succès.");
        return "redirect:index";
    }

}
