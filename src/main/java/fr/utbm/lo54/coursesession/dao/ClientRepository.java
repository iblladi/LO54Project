package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
}
