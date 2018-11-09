package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.entity.Course;
import fr.utbm.lo54.coursesession.metier.CourseMetier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseMetier {

    @Override
    public List<Course> listCourse() {
        return null;
    }

    @Override
    public Course saveCourse(Course c) {
        return null;
    }

    @Override
    public void updateCourse(Course c) {

    }

    @Override
    public void deleteCourse(Long id) {

    }

    @Override
    public boolean CourseExists(Course c) {
        return false;
    }

    @Override
    public Course findOne(Long id) {
        return null;
    }
}
