package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.CourseSessionClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSessionClientRepository extends CrudRepository<CourseSessionClient,Long> {
}
