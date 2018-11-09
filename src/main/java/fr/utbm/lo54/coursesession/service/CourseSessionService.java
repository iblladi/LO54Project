package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.entity.CourseSession;
import fr.utbm.lo54.coursesession.metier.CourseSessionMetier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSessionService implements CourseSessionMetier {

    @Override
    public List<CourseSession> listCourseSession() {
        return null;
    }

    @Override
    public CourseSession saveCourseSession(CourseSession c) {
        return null;
    }

    @Override
    public void updateCourseSession(CourseSession c) {

    }

    @Override
    public void deleteCourseSession(Long id) {

    }

    @Override
    public boolean CourseSessionExists(CourseSession c) {
        return false;
    }

    @Override
    public CourseSession findOne(Long id) {
        return null;
    }
}
