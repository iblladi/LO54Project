package fr.utbm.lo54.coursesession.entity;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Course_Session")
public class CourseSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseSession_id")
    private Long id;

    private String available = "Disponible";

    @DateTimeFormat(iso= ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso=ISO.DATE)
    private LocalDate endEnd;

    @NotNull
    private int nbplaces = 10;

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

    public CourseSession(String available, LocalDate startDate, LocalDate endEnd, int nbplaces, Location location, Course course) {
        this.available = available;
        this.startDate = startDate;
        this.endEnd = endEnd;
        this.nbplaces = nbplaces;
        this.location = location;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndEnd() {
        return endEnd;
    }

    public void setEndEnd(LocalDate endEnd) {
        this.endEnd = endEnd;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
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
        return nbplaces == that.nbplaces &&
                Objects.equals(id, that.id) &&
                Objects.equals(available, that.available) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endEnd, that.endEnd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(course, that.course) &&
                Objects.equals(couseSessionClients, that.couseSessionClients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, available, startDate, endEnd, nbplaces, location, course, couseSessionClients);
    }

    @Override
    public String toString() {
        return "CourseSession{" +
                "id=" + id +
                ", available='" + available + '\'' +
                ", startDate=" + startDate +
                ", endEnd=" + endEnd +
                ", nbplaces=" + nbplaces +
                ", location=" + location +
                ", course=" + course +
                ", couseSessionClients=" + couseSessionClients +
                '}';
    }
}
