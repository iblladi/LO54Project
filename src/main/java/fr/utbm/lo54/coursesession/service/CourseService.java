package fr.utbm.lo54.coursesession.service;

import fr.utbm.lo54.coursesession.dao.CourseRepository;
import fr.utbm.lo54.coursesession.entity.Course;
import fr.utbm.lo54.coursesession.metier.CourseMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseMetier {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> listCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public void updateCourse(Course c) {
        saveCourse(c);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    public boolean CourseExists(Course c) {
        return false;
    }

    @Override
    public Course findOne(String id) {
        return courseRepository.getOne(id);
    }

    @Override
    public Page<Course> searchCourse(String t, Pageable pageable) {
        return courseRepository.searchCourse(t,pageable);
    }
}
