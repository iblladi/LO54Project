package fr.utbm.lo54.coursesession.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Course implements Serializable {

    @Id
    @GenericGenerator(name = "sequence_crs_id", strategy = "fr.utbm.lo54.coursesession.sequence.CourseIdGenerator")
    @GeneratedValue(generator = "sequence_crs_id")
    @Column(name = "course_id")
    private String id;

    @NotNull
    private String title;

    @OneToMany(mappedBy = "course")
    private Collection<CourseSession> courseSessions;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(title, course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
