package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,Long> {
}
