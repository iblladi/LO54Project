package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.CourseSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CourseSessionMetier {

    public List<CourseSession> listCourseSession();

    public CourseSession saveCourseSession(CourseSession c);

    public void updateCourseSession(CourseSession c);

    public void deleteCourseSession(Long id);

    public boolean CourseSessionExists(CourseSession c);

    public CourseSession findOne(Long id);

    public Page<CourseSession> searchByCity(String city, Pageable pageable);

    public Page<CourseSession> searchByDateAndAvailable(@Param("d") LocalDate date, Pageable pageable);

}

