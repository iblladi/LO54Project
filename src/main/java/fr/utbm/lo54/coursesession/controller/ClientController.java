package fr.utbm.lo54.coursesession.controller;

import fr.utbm.lo54.coursesession.entity.Client;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class ClientController {

    @Autowired
    ClientMetier clientMetier;

    @RequestMapping(value= {"/index","/"})
    public String index(Model model, Principal p, HttpServletRequest request) {
        //
        return "index";
    }


    @RequestMapping(value= {"/home"})
    public String home(Model model, Principal p, HttpServletRequest request) {
        Client client = clientMetier.findByEmail(p.getName());
        model.addAttribute("profil", client);
        return "home";
    }

    /*PROFIL*/
    @RequestMapping(value="/profil")
    public String profil(Model model,Principal p,HttpServletRequest request) {
        Client client = clientMetier.findByEmail(p.getName());
        model.addAttribute("profil", client);
        return "profil";
    }
}
