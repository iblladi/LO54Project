package fr.utbm.lo54.coursesession.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CourseSession_Client")
@IdClass(CourseSessionClientId.class)
public class CourseSessionClient implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "courseSession_id")
    private CourseSession courseSession;

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public CourseSessionClient(CourseSession courseSession, Client client) {
        this.courseSession = courseSession;
        this.client = client;
    }

    public CourseSession getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSessionClient that = (CourseSessionClient) o;
        return Objects.equals(courseSession, that.courseSession) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseSession, client);
    }

    @Override
    public String toString() {
        return "CourseSessionClient{" +
                "courseSession=" + courseSession +
                ", client=" + client +
                '}';
    }
}
