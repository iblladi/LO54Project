package fr.utbm.lo54.coursesession.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Course implements Serializable {

    @Id
    @Column(name = "course_id")
    private String id;

    @NotNull
    private String title;

    @Lob
    private String description;

    @OneToMany(mappedBy = "course")
    private Collection<CourseSession> courseSessions;

    public Course() {
    }

    public Course(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(title, course.title) &&
                Objects.equals(description, course.description) &&
                Objects.equals(courseSessions, course.courseSessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, courseSessions);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", courseSessions=" + courseSessions +
                '}';
    }
}
