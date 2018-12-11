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
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Long nbInscrits = courseSessionMetier.nbInscrits(id);

        if (date == null){
            Page<CourseSession> cs = courseSessionMetier.searchByCity(id,"%"+mc+"%", new PageRequest(pg, s));
            model.addAttribute("listcs",cs.getContent());
            int[] pages = new int [cs.getTotalPages()];
            model.addAttribute("pages", pages);
            model.addAttribute("pageCourante", pg);
            model.addAttribute("motCle", mc);
            model.addAttribute("crs", crs);
            model.addAttribute("nbinsc", nbInscrits);
            model.addAttribute("crsession",cs);
            model.addAttribute("listville",l);
            return "list/session";

        }
        Page<CourseSession> cs = courseSessionMetier.searchByCityAndDate(id,date,"%"+mc+"%", new PageRequest(pg, s));
        model.addAttribute("listcs",cs.getContent());
        int[] pages = new int [cs.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", pg);
        model.addAttribute("motCle", mc);
        model.addAttribute("date",date);
        model.addAttribute("crs", crs);
        model.addAttribute("nbinsc", nbInscrits);
        model.addAttribute("crsession",cs);
        model.addAttribute("listville",l);
        return "list/session";
    }


    @RequestMapping(value = "/sessions",method= RequestMethod.GET)
    public String listSessions(Model model, @ModelAttribute("crs") Course crs1,
                              @RequestParam(name="id") String id,
                              @RequestParam(name="date",required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                              @RequestParam(name="page",defaultValue="0")int pg,
                              @RequestParam(name="page1",defaultValue="0")int pg1,
                              @RequestParam(name="size",defaultValue="4")int s,
                              @RequestParam(name="motCle",defaultValue="%")String mc) {

        List<Location> l = locationMetier.listLocation();
        Course crs = courseMetier.findOne(id);
        Long nbInscrits = courseSessionMetier.nbInscrits(id);

        if (date == null) {
            Page<CourseSession> cs = courseSessionMetier.searchByCity(id, "%" + mc + "%", new PageRequest(pg, s));
            model.addAttribute("listcs", cs.getContent());
            int[] pages = new int[cs.getTotalPages()];
            model.addAttribute("pages", pages);
            model.addAttribute("pageCourante", pg);
            model.addAttribute("motCle", mc);
            model.addAttribute("crs", crs);
            model.addAttribute("nbinsc", nbInscrits);
            model.addAttribute("crsession", cs);
            model.addAttribute("listville", l);
            return "list/sessions";

        }
        Page<CourseSession> cs = courseSessionMetier.searchByCityAndDate(id, date, "%" + mc + "%", new PageRequest(pg, s));
        model.addAttribute("listcs", cs.getContent());
        int[] pages = new int[cs.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", pg);
        model.addAttribute("motCle", mc);
        model.addAttribute("date", date);
        model.addAttribute("crs", crs);
        model.addAttribute("nbinsc", nbInscrits);
        model.addAttribute("crsession", cs);
        model.addAttribute("listville", l);
        return "list/sessions";
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


    /*Partie Administration*/

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/formCourseSession", method = RequestMethod.GET)
    public String formCourseSession(Model model, String id){
        model.addAttribute("course", courseMetier.findOne(id));
        model.addAttribute("locations", locationMetier.listLocation());
        model.addAttribute("crs",new CourseSession());
        return "form/formCourseSession";
    }

    @RequestMapping(value = "/saveCourseSession" , method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("crs") CourseSession crs,final RedirectAttributes redirectAttributes){
        courseSessionMetier.saveCourseSession(crs);
        redirectAttributes.addFlashAttribute("message","Création de la session a été effectuée avec succès.");
        return "redirect:cours?id="+crs.getCourse().getId();
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value="/editCourseSession",method=RequestMethod.GET)
    public String editCourse(Model model, Long id){
        model.addAttribute("courses", courseMetier.listCourse());
        model.addAttribute("locations", locationMetier.listLocation());
        model.addAttribute("crs",courseSessionMetier.findOne(id));
        return "edit/editCourseSession";
    }

    @RequestMapping(value="/updateCourseSession",method=RequestMethod.POST)
    public String udpateCourse(@ModelAttribute("crs") CourseSession crs,final RedirectAttributes redirectAttributes) {
        crs.setAvailable(crs.getAvailable());
        crs.setStartDate(crs.getStartDate());
        crs.setEndDate(crs.getEndDate());
        courseSessionMetier.updateCourseSession(crs);
        redirectAttributes.addFlashAttribute("message","Modification de la session a été effectuée avec succès.");
        return "redirect:session?id="+crs.getCourse().getId();
    }

}
