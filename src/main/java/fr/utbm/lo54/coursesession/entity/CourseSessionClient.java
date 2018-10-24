package fr.utbm.lo54.coursesession.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CourseSession_Client")
public class CourseSessionClient implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "courseSession_id")
    private CourseSession courseSession;

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
