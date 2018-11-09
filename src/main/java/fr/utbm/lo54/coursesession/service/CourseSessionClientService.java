package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.entity.CourseSessionClient;
import fr.utbm.lo54.coursesession.metier.CourseSessionClientMetier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSessionClientService implements CourseSessionClientMetier {

    @Override
    public List<CourseSessionClient> listCourseSessionClient() {
        return null;
    }

    @Override
    public CourseSessionClient saveCourseSessionClient(CourseSessionClient c) {
        return null;
    }

    @Override
    public void updateCourseSessionClient(CourseSessionClient c) {

    }

    @Override
    public void deleteCourseSessionClient(Long id) {

    }

    @Override
    public boolean CourseSessionClientExists(CourseSessionClient c) {
        return false;
    }

    @Override
    public CourseSessionClient findOne(Long id) {
        return null;
    }
}
