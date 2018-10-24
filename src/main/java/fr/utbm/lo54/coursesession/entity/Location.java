package fr.utbm.lo54.coursesession.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    private String city;

    @OneToMany(mappedBy = "location")
    private Collection<CourseSession> courseSessions;

    public Location() {
    }


}
