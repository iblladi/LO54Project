package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    @Query("select c from Course c where c.title like :x")
    public Page<Course> searchCourse(@Param("x") String t, Pageable pageable);

}
