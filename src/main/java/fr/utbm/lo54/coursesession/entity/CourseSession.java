package fr.utbm.lo54.coursesession.entity;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    private LocalDate endDate;

    @NotNull
    private int nbplaces = 10;

    @NotNull
    private int nbrestants = 10;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany(mappedBy = "courseSessions")
    private Set<Client> clients = new HashSet<>();


    public CourseSession() {
    }

    public CourseSession(LocalDate startDate, LocalDate endDate, Location location, Course course) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.course = course;
    }

    public CourseSession(String available, LocalDate startDate, LocalDate endDate, int nbplaces, Location location, Course course) {
        this.available = available;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public int getNbrestants() {
        return nbrestants;
    }

    public void setNbrestants(int nbrestants) {
        this.nbrestants = nbrestants;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
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
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(location, that.location) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, available, startDate, endDate, nbplaces, location, course);
    }

    @Override
    public String toString() {
        return "CourseSession{" +
                "id=" + id +
                ", available='" + available + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", nbplaces=" + nbplaces +
                ", location=" + location +
                ", course=" + course +
                '}';
    }
}
