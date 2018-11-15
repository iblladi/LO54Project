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

        Course crs1 = new Course("CRS_001","J2EE/JAVA","JAVA et JEE sont les technologies les plus " +
                "répandues pour le développement des applications. La Formation JAVA pour devenir Développeur Java/JEE , " +
                "proposée par LO54 est un cursus unique qui permet rapidement d'être opérationnel sur ce langage.");
        courseRepository.save(crs1);

        Course crs2 = new Course("CRS_002","PL/SQL","Le cours PL/SQL a comme objectif la maîtrise du " +
                "langage PL/SQL et l'utilisation des traitements stockés et des triggers dans les applications. Les concepts " +
                "abordés sont systématiquement mis en pratique.");
        courseRepository.save(crs2);

        Course crs3 = new Course("CRS_003","Analyse de données","Mettre en œuvre une analyse statistique dans Excel pour " +
                "faire des choix pertinents, apprendre à en synthétiser les résultats pour les diffuser.");
        courseRepository.save(crs3);

        Course crs4 = new Course("CRS_004","Python","Python est un langage de programmation multiplateforme permettant le " +
                "développement d'une grande variété d'applications. Ce stage vous permettra d'en maîtriser sa syntaxe, ses principaux mécanismes " +
                "et son paradigme Objet. Vous découvrirez les principales fonctionnalités de la bibliothèque de modules standards, implémenterez " +
                "des interfaces graphiques, accéderez aux données d'une base tout en appliquant sur la chaîne de développement les outils permettant " +
                "de tester et d'évaluer la qualité du code produit.");
        courseRepository.save(crs4);

        Course crs5 = new Course("CRS_005","Logiciel R","Cette formation s'adresse à des personnes souhaitant prendre en main le logiciel R : " +
                "son interface, sa syntaxe, ses objets afin que le stagiaire devienne autonome dans le traitement de ses données. Il ne s’agit donc pas d’une formation " +
                "sur la méthodologie statistique mais bien d’une formation sur le logiciel R. De même, il ne s’agit pas d’une formation sur les techniques de programmation " +
                "avancée sous R.");
        courseRepository.save(crs5);

        Course crs6 = new Course("CRS_006","Business Intelligence","L’analyse décisionnelle est un véritable enjeu pour l’avenir des organisations. Il est " +
                "essentiel d’appréhender les évolutions de la Business Intelligence dans un environnement en pleine mutation (Big Data, NoSQL, nouvelles architectures, nouveaux outils, " +
                "nouvelles formes d’analyses...) pour maîtriser la mise en place de votre système décisionnel");
        courseRepository.save(crs6);

        Location l1 = new Location("Paris");
        locationRepository.save(l1);

        Location l2 = new Location("Belfort");
        locationRepository.save(l2);

        Client c = new Client("Blladi", "Ismail", "8 Rue de Ferrette", "062586487","pass", passwordEncoder.encode("pass"),"ADMIN");
        clientRepository.save(c);

        Client c1 = new Client("Blladi", "Ismail", "8 Rue de Ferrette", "062586487","pass1", passwordEncoder.encode("pass"),"CLIENT");
        clientRepository.save(c1);

        CourseSession cs = new CourseSession(LocalDate.of(2018, 12, 9), LocalDate.of(2019, 1, 8), l1, crs1);
        courseSessionRepository.save(cs);



    }
}

