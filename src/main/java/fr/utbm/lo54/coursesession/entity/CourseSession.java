package fr.utbm.lo54.coursesession.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

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

    public CourseSession() {
    }

    public CourseSession(LocalDateTime startDate, LocalDateTime endEnd, int max, Location location, Course course) {
        this.startDate = startDate;
        this.endEnd = endEnd;
        this.max = max;
        this.location = location;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndEnd() {
        return endEnd;
    }

    public void setEndEnd(LocalDateTime endEnd) {
        this.endEnd = endEnd;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSession that = (CourseSession) o;
        return max == that.max &&
                Objects.equals(id, that.id) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endEnd, that.endEnd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endEnd, max, location, course);
    }

    @Override
    public String toString() {
        return "CourseSession{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endEnd=" + endEnd +
                ", max=" + max +
                ", location=" + location +
                ", course=" + course +
                '}';
    }
}
