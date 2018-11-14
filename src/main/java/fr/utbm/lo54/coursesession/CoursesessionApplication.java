package fr.utbm.lo54.coursesession;

import fr.utbm.lo54.coursesession.dao.*;
import fr.utbm.lo54.coursesession.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import java.time.LocalDate;

@SpringBootApplication
public class CoursesessionApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    @Autowired
    private CourseSessionClientRepository courseSessionClientRepository;


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }

    public static void main(String[] args) {
        SpringApplication.run(CoursesessionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Course crs = new Course("CRS_001","J2EE Developper");
        courseRepository.save(crs);

        Location l = new Location("Paris");
        locationRepository.save(l);

        Client c = new Client("toto", "tata", "titi", "062586487","admin@lo54.fr", passwordEncoder.encode("pass"),"ADMIN");
        clientRepository.save(c);

        CourseSession cs = new CourseSession(LocalDate.of(2018, 12, 9), LocalDate.of(2019, 1, 8), l, crs);
        courseSessionRepository.save(cs);

        /*CourseSessionClient csc = new  CourseSessionClient(cs,c);
        courseSessionClientRepository.save(csc);*/

    }
}

