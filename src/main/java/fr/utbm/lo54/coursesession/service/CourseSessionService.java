package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.dao.CourseSessionRepository;
import fr.utbm.lo54.coursesession.entity.CourseSession;
import fr.utbm.lo54.coursesession.metier.CourseSessionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSessionService implements CourseSessionMetier {

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    @Override
    public List<CourseSession> listCourseSession() {
        return courseSessionRepository.findAll();
    }

    @Override
    public CourseSession saveCourseSession(CourseSession cs) {
        return courseSessionRepository.save(cs);
    }

    @Override
    public void updateCourseSession(CourseSession cs) {
        saveCourseSession(cs);
    }

    @Override
    public void deleteCourseSession(Long id) {
        courseSessionRepository.deleteById(id);
    }

    @Override
    public boolean CourseSessionExists(CourseSession cs) {
        return false;
    }

    @Override
    public CourseSession findOne(Long id) {
        return courseSessionRepository.getOne(id);
    }
}
