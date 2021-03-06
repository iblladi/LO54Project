package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.CourseSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CourseSessionMetier {

    public CourseSession saveCourseSession(CourseSession c);

    public void updateCourseSession(CourseSession c);

    public CourseSession findOne(Long id);

    public Page<CourseSession> searchByCity(String id, String city, Pageable pageable);

    public Page<CourseSession> searchByCityAndDate(@Param("id") String id,@Param("d") LocalDate date,@Param("city") String city, Pageable pageable);

    public Page<CourseSession> searchMySessions(Long id, Pageable pageable);

    public Long nbInscrits(String id);

}

