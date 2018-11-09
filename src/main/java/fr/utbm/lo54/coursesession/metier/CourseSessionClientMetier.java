package fr.utbm.lo54.coursesession.metier;

import fr.utbm.lo54.coursesession.entity.CourseSessionClient;

import java.util.List;

public interface CourseSessionClientMetier {

    public List<CourseSessionClient> listCourseSessionClient();

    public CourseSessionClient saveCourseSessionClient(CourseSessionClient c);

    public void updateCourseSessionClient(CourseSessionClient c);

    public void deleteCourseSessionClient(Long id);

    public boolean CourseSessionClientExists(CourseSessionClient c);

    public CourseSessionClient findOne(Long id);

}
