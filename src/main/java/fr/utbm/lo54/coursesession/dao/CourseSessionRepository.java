package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.CourseSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession,Long> {

    @Query("select cs from CourseSession cs where cs.startDate = :d")
    public Page<CourseSession> searchByDateAndAvailable(@Param("d") LocalDate date, Pageable pageable);

    @Query("select cs from CourseSession cs join cs.location l join cs.course c where l.city like :city and c.id = :id ")
    public Page<CourseSession> searchByCity(@Param("id") String id,@Param("city") String city, Pageable pageable);

    @Query("select cs from CourseSession cs join cs.location l join cs.course c where l.city like :city and c.id = :id and (cs.startDate <= :d and cs.endDate >= :d )")
    public Page<CourseSession> searchByCityAndDate(@Param("id") String id,@Param("d") LocalDate date,@Param("city") String city, Pageable pageable);

    @Query(value = "SELECT * FROM CLIENT_COURSESESSIONS CCS INNER JOIN COURSE_SESSION CS ON CCS.course_session_id = CS.course_session_id WHERE CLIENT_ID = ?1", nativeQuery = true)
    public Page<CourseSession> searchMySessions(Long id, Pageable pageable);

    @Query(value = "SELECT 100-(COUNT(*)*100/CS.NBPLACES) FROM CLIENT_COURSESESSIONS CCS INNER JOIN COURSE_SESSION CS ON CCS.course_session_id = CS.course_session_id WHERE CS.COURSE_ID= ?1", nativeQuery = true)
    public Long pourcentageInscrits(String id);

    @Query(value = "SELECT COUNT(*) FROM CLIENT_COURSESESSIONS CCS INNER JOIN COURSE_SESSION CS ON CCS.course_session_id = CS.course_session_id WHERE CS.COURSE_ID= ?1", nativeQuery = true)
    public Long nbInscrits(String id);

}
