package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.CourseSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSessionRepository extends CrudRepository<CourseSession,Long> {
}
