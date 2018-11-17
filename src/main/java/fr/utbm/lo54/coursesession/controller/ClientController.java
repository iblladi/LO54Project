package fr.utbm.lo54.coursesession.controller;

import fr.utbm.lo54.coursesession.entity.Client;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class ClientController {

    @Autowired
    private ClientMetier clientMetier;

    @RequestMapping(value= {"/index","/"}, method=RequestMethod.GET)
    public String index(Model model, Principal p, HttpServletRequest request) {
        //
        return "index";
    }


    @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
    public String home(Model model, Principal p, HttpServletRequest request) {
        Client client = clientMetier.findByEmail(p.getName());
        model.addAttribute("profil", client);
        return "home";
    }

    /*PROFIL*/
    @RequestMapping(value="/profil", method= RequestMethod.GET)
    public String profil(Model model,Principal p,HttpServletRequest request) {
        Client client = clientMetier.findByEmail(p.getName());
        model.addAttribute("profil", client);
        return "profil";
    }

    /* FORMULAIRES */
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("client", new Client());
        return "form/registration";
    }

    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String addClient(Model model, @ModelAttribute("client") Client cl, final RedirectAttributes redirectAttributes){
        if (clientMetier.clientExists(cl)) {
            model.addAttribute("message", "Email/Client déjà existant");
            return "erreurs/erreur";
        }
        clientMetier.saveClient(cl);
        redirectAttributes.addFlashAttribute("message","Inscription a été effectué avec succès.");
        return "redirect:index";
    }

    /*PAGE 403 ACCESS DENIED*/
    @RequestMapping(value="/403")
    public String accessDenied() {
        return "erreurs/403";
    }
}
