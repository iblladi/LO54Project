package fr.utbm.lo54.coursesession.controller;

import fr.utbm.lo54.coursesession.entity.Course;
import fr.utbm.lo54.coursesession.entity.CourseSession;
import fr.utbm.lo54.coursesession.entity.Location;
import fr.utbm.lo54.coursesession.metier.ClientMetier;
import fr.utbm.lo54.coursesession.metier.CourseMetier;
import fr.utbm.lo54.coursesession.metier.CourseSessionMetier;
import fr.utbm.lo54.coursesession.metier.LocationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CourseSessionController {

    @Autowired
    private CourseSessionMetier courseSessionMetier;

    @Autowired
    private LocationMetier locationMetier;

    @Autowired
    private CourseMetier courseMetier;

    @Autowired
    private ClientMetier clientMetier;

    @RequestMapping(value = "/session",method= RequestMethod.GET)
    public String listSession(Model model, @ModelAttribute("crs") Course crs1,
                              @RequestParam(name="id") String id,
                              @RequestParam(name="date",required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                              @RequestParam(name="page",defaultValue="0")int pg,
                              @RequestParam(name="page1",defaultValue="0")int pg1,
                              @RequestParam(name="size",defaultValue="4")int s,
                              @RequestParam(name="motCle",defaultValue="%")String mc){

        List<Location> l = locationMetier.listLocation();
        Course crs = courseMetier.findOne(id);
        Page<CourseSession> cs = courseSessionMetier.searchByCity(id,"%"+mc+"%", new PageRequest(pg, s));
        Page<CourseSession> cs1 = courseSessionMetier.searchByDateAndAvailable(date,new PageRequest(pg, s));
        Long nbInscrits = courseSessionMetier.nbInscrits(id);
        model.addAttribute("listcs",cs.getContent());
        int[] pages = new int [cs.getTotalPages()];
        model.addAttribute("listcs1",cs1.getContent());
        int[] pages1 = new int [cs1.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pages1", pages1);
        model.addAttribute("pageCourante", pg);
        model.addAttribute("pageCourante1", pg1);
        model.addAttribute("motCle", mc);
        model.addAttribute("date",date);
        model.addAttribute("crs", crs);
        model.addAttribute("nbinsc", nbInscrits);
        model.addAttribute("crsession",cs);
        model.addAttribute("crsession1",cs1);
        model.addAttribute("id", crs1.getId());
        model.addAttribute("listville",l);
        return "list/session";
    }


    @RequestMapping(value = "/MyCourseSessionCart",method = RequestMethod.GET)
    public String myCourseSessionCart(Model model, Principal p, @RequestParam(name="page",defaultValue="0")int pg,
                                      @RequestParam(name="size",defaultValue="4")int s){

        Page<CourseSession> cs = courseSessionMetier.searchMySessions(clientMetier.findByEmail(p.getName()).getId(),new PageRequest(pg,s));
        model.addAttribute("listmycourses",cs.getContent());
        int[] pages = new int [cs.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", pg);
        return "list/MyCourseSessionCart";
    }

}
