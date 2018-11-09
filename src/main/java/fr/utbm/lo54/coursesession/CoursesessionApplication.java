package fr.utbm.lo54.coursesession;

import fr.utbm.lo54.coursesession.dao.CourseRepository;
import fr.utbm.lo54.coursesession.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoursesessionApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(CoursesessionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*Course crs = new Course("CRS_001","J2EE Developper");
        courseRepository.save(crs);*/

    }
}

