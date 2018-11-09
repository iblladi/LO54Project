package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.dao.CourseSessionClientRepository;
import fr.utbm.lo54.coursesession.entity.CourseSessionClient;
import fr.utbm.lo54.coursesession.metier.CourseSessionClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSessionClientService implements CourseSessionClientMetier {

    @Autowired
    private CourseSessionClientRepository courseSessionClientRepository;

    @Override
    public List<CourseSessionClient> listCourseSessionClient() {
        return courseSessionClientRepository.findAll();
    }

    @Override
    public CourseSessionClient saveCourseSessionClient(CourseSessionClient csc) {
        return courseSessionClientRepository.save(csc);
    }

    @Override
    public void updateCourseSessionClient(CourseSessionClient csc) {
        saveCourseSessionClient(csc);
    }

    @Override
    public void deleteCourseSessionClient(Long id) {
        courseSessionClientRepository.deleteById(id);
    }

    @Override
    public boolean CourseSessionClientExists(CourseSessionClient csc) {
        return false;
    }

    @Override
    public CourseSessionClient findOne(Long id) {
        return courseSessionClientRepository.getOne(id);
    }
}
