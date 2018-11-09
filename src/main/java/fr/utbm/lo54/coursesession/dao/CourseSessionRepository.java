package fr.utbm.lo54.coursesession.dao;

import fr.utbm.lo54.coursesession.entity.CourseSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession,Long> {

    @Query("select cs from CourseSession cs where cs.startDate < :d and cs.endEnd > :d")
    public Page<CourseSession> searchByDateAndAvailable(@Param("d") LocalDate date, Pageable pageable);

    @Query("select cs from CourseSession cs join cs.location l where l.city =?1 ")
    public Page<CourseSession> searchByCity(String city, Pageable pageable);
}
