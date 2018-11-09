package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,String> {
}
