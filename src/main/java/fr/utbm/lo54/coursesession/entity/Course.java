package fr.utbm.lo54.coursesession.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Course implements Serializable {

    @Id
    @GenericGenerator(name = "sequence_crs_id", strategy = "fr.utbm.lo54.coursesession.sequence.CourseIdGenerator")
    @GeneratedValue(generator = "sequence_crs_id")
    @Column(name = "course_id")
    private String id;

    private String title;

    @OneToMany(mappedBy = "course")
    private Collection<CourseSession> courseSessions;

    public Course() {
    }


}
