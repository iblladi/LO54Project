package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    public Client findByEmail(String email);

    @Query(value = "SELECT C.email FROM CLIENT_COURSESESSIONS CCS INNER JOIN CLIENT C ON CCS.client_id = C.client_id WHERE CCS.CLIENT_ID = ?1 and CCS.COURSE_SESSION_ID =?2", nativeQuery = true)
    public String searchRegistredInSession(Long id,Long id1);
}
