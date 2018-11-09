package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.CourseSession;

import java.util.List;

public interface CourseSessionMetier {

    public List<CourseSession> listCourseSession();

    public CourseSession saveCourseSession(CourseSession c);

    public void updateCourseSession(CourseSession c);

    public void deleteCourseSession(Long id);

    public boolean CourseSessionExists(CourseSession c);

    public CourseSession findOne(Long id);

}

