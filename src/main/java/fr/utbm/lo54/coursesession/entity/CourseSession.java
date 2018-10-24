package fr.utbm.lo54.coursesession.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "Course_Session")
public class CourseSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseSession_id")
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endEnd;

    private int max;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "courseSession")
    private Collection<CourseSessionClient> couseSessionClients;


}
