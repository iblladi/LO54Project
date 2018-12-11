package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.dao.CourseSessionRepository;
import fr.utbm.lo54.coursesession.entity.CourseSession;
import fr.utbm.lo54.coursesession.metier.CourseSessionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseSessionService implements CourseSessionMetier {

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    @Override
    public CourseSession saveCourseSession(CourseSession cs) {
        return courseSessionRepository.save(cs);
    }

    @Override
    public void updateCourseSession(CourseSession cs) {
        saveCourseSession(cs);
    }

    @Override
    public CourseSession findOne(Long id) {
        return courseSessionRepository.getOne(id);
    }

    @Override
    public Page<CourseSession> searchByCity(String id,String city, Pageable pageable) {
        return courseSessionRepository.searchByCity(id, city, pageable);
    }

    @Override
    public Page<CourseSession> searchMySessions(Long id,  Pageable pageable) {
        return courseSessionRepository.searchMySessions(id , pageable);
    }

    @Override
    public Long nbInscrits(String id){
        return courseSessionRepository.nbInscrits(id);
    }


    @Override
    public Page<CourseSession> searchByCityAndDate(String id, LocalDate date, String city, Pageable pageable) {
        return courseSessionRepository.searchByCityAndDate(id,date,city,pageable);
    }


}
