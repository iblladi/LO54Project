package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseMetier {

    public List<Course> listCourse();

    public Course saveCourse(Course c);

    public void updateCourse(Course c);

    public void deleteCourse(String id);

    public boolean CourseExists(Course c);

    public Course findOne(String id);

    public Page<Course> searchCourse(@Param("x") String t, Pageable pageable);


}
