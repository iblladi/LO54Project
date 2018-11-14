package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.CourseSessionClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSessionClientRepository extends JpaRepository<CourseSessionClient,Long> {

    @Query("select count(csc) from CourseSessionClient csc where csc.courseSession=?2 and csc.client=?1 group by csc.client, csc.courseSession")
    public int nbInscrits(Long clientId, Long courseSessionId);
}
