package fr.utbm.lo54.coursesession.controller;

import fr.utbm.lo54.coursesession.entity.Course;
import fr.utbm.lo54.coursesession.metier.CourseMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @Autowired
    private CourseMetier courseMetier;

    @RequestMapping(value= {"/cours"},method= RequestMethod.GET)
    public String listCourse(Model model, @RequestParam(name="page",defaultValue="0")int pg,
                                @RequestParam(name="size",defaultValue="4")int s, @RequestParam(name="motCle",defaultValue="")String mc) {
        Page<Course> p = courseMetier.searchCourse("%"+mc+"%", new PageRequest(pg, s));
        model.addAttribute("listcourse",p.getContent());
        int[] pages = new int [p.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", pg);
        model.addAttribute("motCle", mc);
        return "list/cours";
    }
}
