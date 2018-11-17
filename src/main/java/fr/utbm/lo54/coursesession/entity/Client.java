package fr.utbm.lo54.coursesession.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String phone;

    @NotNull
    private String address;

    @NotNull
    private boolean activated = true;

    @NotNull
    private String role = "CLIENT";

    @ManyToMany
    @JoinTable(name = "client_coursesessions", joinColumns = { @JoinColumn(name = "client_id")}, inverseJoinColumns = {@JoinColumn(name = "courseSession_id")})
    private Set<CourseSession> courseSessions = new HashSet<>();

    public Client() {
    }

    public Client(@NotNull String lastName, @NotNull String firstName, @NotNull String address, @NotNull String phone, @NotNull String email, @NotNull String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Client(@NotNull String lastName, @NotNull String firstName, @NotNull String address, @NotNull String phone, @NotNull String email, @NotNull String password, @NotNull String role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Set<CourseSession> getCourseSessions() {
        return courseSessions;
    }

    public void setCourseSessions(Set<CourseSession> courseSessions) {
        this.courseSessions = courseSessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(address, client.address) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(email, client.email) &&
                Objects.equals(password, client.password) &&
                Objects.equals(role, client.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, address, phone, email, password, role);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
