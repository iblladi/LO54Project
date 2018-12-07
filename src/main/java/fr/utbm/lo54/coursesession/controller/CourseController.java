package fr.utbm.lo54.coursesession.controller;

import fr.utbm.lo54.coursesession.entity.Course;
import fr.utbm.lo54.coursesession.metier.CourseMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CourseController {

    @Autowired
    private CourseMetier courseMetier;

    @RequestMapping(value= {"/cours"},method= RequestMethod.GET)
    public String listCourse(Model model, @RequestParam(name="page",defaultValue="0")int pg,
                                @RequestParam(name="size",defaultValue="4")int s, @RequestParam(name="motCle",defaultValue="")String mc) {
        Page<Course> c = courseMetier.searchCourse("%"+mc+"%", new PageRequest(pg, s));
        model.addAttribute("listcourse",c.getContent());
        int[] pages = new int [c.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", pg);
        model.addAttribute("motCle", mc);
        return "list/cours";
    }

    @RequestMapping(value= {"/coursDispo"},method= RequestMethod.GET)
    public String listCourseDispo(Model model, @RequestParam(name="page",defaultValue="0")int pg,
                             @RequestParam(name="size",defaultValue="4")int s, @RequestParam(name="motCle",defaultValue="")String mc) {
        Page<Course> c = courseMetier.searchCourse("%"+mc+"%", new PageRequest(pg, s));
        model.addAttribute("listcourse",c.getContent());
        int[] pages = new int [c.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", pg);
        model.addAttribute("motCle", mc);
        return "list/coursDispo";
    }


    @RequestMapping(value = "/addCourse", method = RequestMethod.GET)
    public String addCourse(Model model){
        model.addAttribute("cr",new Course());
        return "form/addCourse";
    }

    @RequestMapping(value = "/saveCourse" , method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("cr") Course cr,final RedirectAttributes redirectAttributes){
        courseMetier.saveCourse(cr);
        redirectAttributes.addFlashAttribute("message","Création du cours a été effectué avec succès.");
        return "redirect:cours";
    }


}
